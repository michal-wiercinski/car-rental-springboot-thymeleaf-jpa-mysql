('#datepicker1').datetimepicker({
  timepicker: true,
  datepicker: true,
  format: 'Y-m-d H:i',
  //weeks: true
  onShow: function (ct) {
    this.setOptions({
      minDate: $('#datepicker2').val() ? $('#datepicker2').val() : false
    })
  }
})
$('#datepicker2').datetimepicker({
  timepicker: true,
  datepicker: true,
  format: 'Y-m-d H:i',
  //weeks: true
  onShow: function (ct) {
    this.setOptions({
      minDate: $('#datepicker1').val() ? $('#datepicker1').val() : false
    })
  }
});
