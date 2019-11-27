$(function() {

	var getProductList = "/S2o/shopadmin/getProductList";
	var html = '';
	getProductInfo();
	function getProductInfo() {
		$.ajax({
					type : "get",
					url : "getProductList",
					dataType : "json",
					success : function(data) {
						if (data.success) {
							handleList(data.ProductList)
						}

					}
				});

	}

	function handleList(data) {
		$('#product-wrap').html('');
		html = "";
		data.map(function(item, index) {

			html += '<div class="row row-shop now"><div class="col-40">'
					+ item.productName
					+ '</div><div class="col-40">'
					+ item.priority
					+ '</div><div class="col-20">'
					+ '<a id="delete2" class="button delete" data-id = "'
					+ item.productId
					+ '">删除</a>'
					+ '<a id="delete2" class="button delete"   href="/S2o/shopadmin/productoperation?productId='
					+ item.productId + '" >修改</a>' + '</div></div>';                                

		});
		$('#product-wrap').append(html);

	}

});