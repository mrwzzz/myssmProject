$(function() {
	var Delete = "/S2o/shopadmin/DeleteProductCategory";
	var shopId = getQueryString('shopId');
	var ProductCategoryListUrl = "/S2o/shopadmin/getProductCategorybyid?shopId="
			+ shopId;
	getProductCategoryInfo();
	var html = '';
	function getProductCategoryInfo() {
		var delectProductCategoryListUrl = "";
		$.ajax({
					type : "get",
					url : ProductCategoryListUrl,
					dataType : "json",
					success : function(data) {
						if (data.success) {
							handleList(data.ProductCategoryList);

						}
					}
				});

	}

	function handleList(data) {
		$('#shop-wrap').html('');
		html = "";
		data.map(function(item, index) {
					html += '<div class="row row-shop now"><div class="col-40">'
							+ item.productCategoryName
							+ '</div><div class="col-40">'
							+ item.priority
							+ '</div><div class="col-20">'
							+ '<a id="delete2" class="button delete" data-id = "'
							+ item.productCategoryid
							+ '">删除</a>'
							+ '</div></div>';

				});
		$('#shop-wrap').append(html);
	}

	function Deletepc() {

		return '<a id="delete" href="">删除</a>';

	}
	$('#delete').click(function() {

				$.ajax({
							type : "get",
							url : ProductCategoryListUrl,
							dataType : "json",
							success : function(data) {
								if (data.success) {
									handleList(data.ProductCategoryList);

								}
							}
						});
			});
	$('#new').click(function() {
		var htmlS = '';
		htmlS += '<div class="row row-shop temp"> <div class = "col-40">'
				+ '<input class="category-input category" type="text" ></input>'
				+ '</div><div class="col-40">'
				+ '<input class="category-input priority" type="number"></input>'
				+ '</div><div class="col-20">'
				+ '<a  id="delete1" class="button delete">删除</a>' + '</div></div>';

		$('#shop-wrap').append(htmlS);

	});
	$('#submit').click(function() {
		var temps = $('.temp');

		var productCategories = [];
		temps.map(function(index, item) {
					var ProductCategoryName = $(item).find('.category').val();
					var priority = $(item).find('.priority').val();
					if (ProductCategoryName != null && priority != null) {
						var productcategory = {};
						productcategory.productCategoryName = ProductCategoryName;
						productcategory.priority = priority;
						productCategories.push(productcategory);

					}

				});
		$.ajax({
					url : '/S2o/shopadmin/addProductcategorys',
					type : 'POST',
					data : JSON.stringify(productCategories),
					contentType : 'application/json',
					success : function(data) {
						if (data.success) {
							$.toast("提交成功!");
							getProductCategoryInfo();
						} else {
							$.toast("提交失败!"+data.errMsg);

						}

					}
				});
	});
	$('#shop-wrap').on('click', '#delete1', function() {
				$(this).parent().parent().remove();

			});
	$('#shop-wrap').on('click', '#delete2', function(e) {
				var target = e.currentTarget;
				$.confirm("你确定吗?", function() {
							$.ajax({

										type : "post",
										url : Delete,
										dataType : 'json',
										data : {
											ProductCategoryId : target.dataset.id

										},
										success : function(data) {

											if (data.success) {
												$.toast('删除成功');

												getProductCategoryInfo();

											} else {
												$.toast('删除失败'+data.errMsg);

											}

										}

									});

						});

			});
});