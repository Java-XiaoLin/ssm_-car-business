$(function() {
		var step= $("#myStep").step({
			animate:true,
			initStep:1,
			speed:1000
		});		
		$("#preBtn").click(function(event) {
			var yes=step.preStep();

		});
		$("#applyBtn").click(function(event) {		
			
		    var code = $.trim($("#Verification").val());
			var email =/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		  var emails = $.trim($("#email").val());
		if ($.trim(emails) == "") {
			Tip('请填写邮箱号码！');
			$("#email").focus();
			return;
		}
		if(!email.exec(emails)){
				Tip('邮箱输入格式不正确,请重新输入');
				$("#email").focus();
			return;
			}

		if ($.trim(code) == "") {
			Tip('激活码未填写！');
			$("#Verification").focus();
			return;
		}
      $.ajax({
        url:"/checkEmail",
        data:{"code":code},
        success:function (result){
          if (result.success){
            let yes=step.nextStep();
            return;
          }else {
            $("#Verification").focus();
            Swal.fire({
              icon: 'error',
              text: result.msg,
            })
          }

        }
      })
		});


		$("#submitBtn").click(function(event) {
			   var txtconfirm = $.trim($("#confirmpwd").val());
			      let tstUser = $("#username").val();
	           var txtPwd = $("#password").val();
        if ($.trim(tstUser) == "") {

          Tips('请输入你要设置的用户名！');
          $("#tstUser").focus();
          return;
        }
	          if ($.trim(txtPwd) == "") {
	
	         	Tips('请输入你要设置的密码！');
		       $("#txtPwd").focus();
		      return;
	            }

      $.ajax({
        url:"/checkUsername",
        data:{"username":tstUser,"password":txtPwd},
        success:function (result){
          if (result.success){
            Swal.fire({
              icon: 'success',
              text: result.msg,
            })
            let yes=step.nextStep();
            $(function () {  setTimeout("lazyGo();", 3000); });

          }else {
            $("#Verification").focus();
            Swal.fire({
              icon: 'error',
              text: result.msg,
            })
            return;
          }
        }
      })
			
		});



		$("#goBtn").click(function(event) {
			var yes=step.goStep(3);
		});	
	});

  function lazyGo() {
    var sec = $("#sec").text();
    $("#sec").text(--sec);
    if (sec > 0)
      setTimeout("lazyGo();", 1000);
    else
      window.location.href = "../../../login.html";
  }


(function (factory) {
    "use strict";
    if (typeof define === 'function') {
        // using CMD; register as anon module
      define.cmd&&define('jquery-step', ['jquery'], function (require, exports, moudles) {
            var $=require("jquery");
            factory($);
            return $;
        });
      define.amd&&define(['jquery'], factory);
    } else {
        // no CMD; invoke directly
        factory( (typeof(jQuery) != 'undefined') ? jQuery : window.Zepto );
    }
}

(function($){
  $.fn.step = function(options) { 
      var opts = $.extend({}, $.fn.step.defaults, options);
      var size=this.find(".step-header li").length;
      var barWidth=opts.initStep<size?100/(2*size)+100*(opts.initStep-1)/size : 100;
      var curPage=opts.initStep;

      this.find(".step-header").prepend("<div class=\"step-bar\"><div class=\"step-bar-active\"></div></div>");
      this.find(".step-list").eq(opts.initStep-1).show();
      if (size<opts.initStep) {
        opts.initStep=size;
      }
      if (opts.animate==false) {
        opts.speed=0;
      }
      this.find(".step-header li").each(function (i, li) {
        if (i<opts.initStep){
          $(li).addClass("step-active");
        }
        //$(li).prepend("<span>"+(i+1)+"</span>");
        $(li).append("<span>"+(i+1)+"</span>");
    });
    this.find(".step-header li").css({
      "width": 100/size+"%"
    });
    this.find(".step-header").show();
    this.find(".step-bar-active").animate({
        "width": barWidth+"%"},
        opts.speed, function() {
        
    });

      this.nextStep=function() {
        if (curPage>=size) {
          return false;
        }
        return this.goStep(curPage+1);
      }

      this.preStep=function() {
        if (curPage<=1) {
          return false;
        }
        return this.goStep(curPage-1);
      }

      this.goStep=function(page) {
        if (page ==undefined || isNaN(page) || page<0) {
          if(window.console&&window.console.error){
            console.error('the method goStep has a error,page:'+page);
          }
        return false;
        }
        curPage=page;
        this.find(".step-list").hide();
        this.find(".step-list").eq(curPage-1).show();
        this.find(".step-header li").each(function (i, li) {
          $li=$(li);
          $li.removeClass('step-active');
          if (i<page){
            $li.addClass('step-active');
            if(opts.scrollTop){
             $('html,body').animate({scrollTop:0}, 'slow');
            }
        }
      });
      barWidth=page<size?100/(2*size)+100*(page-1)/size : 100;
        this.find(".step-bar-active").animate({
          "width": barWidth+"%"},
          opts.speed, function() {
            
        });
        return true;
      }
      return this;
  };
   
  $.fn.step.defaults = {
      animate:true,
      speed:500,
    initStep:1,
    scrollTop:true
  };
})
 );

