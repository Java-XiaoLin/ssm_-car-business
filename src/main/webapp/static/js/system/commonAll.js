$(function (){
  $(".btn-delete").click(function (){
    let url = $(this).data("url");
    let name = $(this).data("name");

    Swal.fire({
      title: '你确定要删除'+name+'吗',
      text: "删除后数据不可恢复",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: '确定',
      cancelButtonText: '取消'
    }).then((result) => {
      if (result.value) {
        Swal.fire({
          title:'删除成功',
          text:  'Your file has been deleted.',
          icon: 'success',
        }
        )
        window.setTimeout(function (){
          window.location.href=url
        },1500);
      }
    })
  })


})
