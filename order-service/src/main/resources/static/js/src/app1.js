$(document).ready(function(){

   $("div.itemRow").hide();

  $("p").click(function(){
    $(this).hide();
  });

  $("button.item-remove").click(function(){
      var index = $(this).attr('id').replace("item-remove", "");
      $("input#item-quantity-" +index).val("0");
      $("div.itemRow#item-" +index).hide();
      $("#item-select-" + index).show();
    });



  $('#orderItemSelect').change(function() {
      if ($(this).val() != '') {
          console.log($(this).val());
          var index = $(this).val();
          var rowItem = $("div.itemRow#item-" +index);
          rowItem.show();
          $("#item-select-" + index).hide();
          $(this).val("");
      }
  });
});
