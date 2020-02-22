
  var sortProperty = /*[[${sortProperty}]]*/ null;
  var sortDesc = /*[[${sortDesc}]]*/ null;

$(document).ready(function () {
  //show up/down arrows
  $("table#sort-table thead th").each(function () {
    var head = $(this);
    if (head.attr('data-sort-prop') == sortProperty) {
      head.append(sortDesc ? '▾' : '▴');
    }
  });
});


  $("table#sort-table thead th").click(function () {
    var headerSortPropName = $(this).attr("data-sort-prop");
    if (headerSortPropName == sortProperty) {
      window.location.href = window.location.pathname +
          '/' + headerSortPropName + ',' +
          (sortDesc ? 'ASC' : 'DESC');
    } else {
      window.location.href = window.location.pathname +
          '/' + headerSortPropName + ',ASC';
    }
  });