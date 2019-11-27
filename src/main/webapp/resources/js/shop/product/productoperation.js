$(function() {

			var productId = getQueryString('productId');
			var intoUrl = "/S2o/shopadmin/getProductbyId?productId="
					+ productId;
			var categortUrl = '/S2o/shopadmin/GetProductCategoryList';
			var productPostUrl = '/S2o/shopadmin/modifyProduct';
			var addProduct = '/S2o/shopadmin/addproduct';
var updateProduct='/S2o/shopadmin/modifyProduct';
			var isEdit = productId ? true : false;

			var index = 6;
			var num1 = 0;
			var num = 0;
			if (isEdit) {
				getProductInfo();

			} else {
				getcategor();
			}

			function getProductInfo() {
				$.getJSON(intoUrl, function(data) {
							if (data.success) {
								var Product = data.Product;
								$('#priority').val(Product.priority);
								$('#shop-name').val(Product.productName);

							}

						});
				getcategor();
			}

			function getcategor() {

				$.getJSON(categortUrl, function(data) {
							var tempCategoryHtml = '';

							if (data.success) {
								data.ProductCategoryList.map(function(item,
												index) {

											tempCategoryHtml += '<option data-id="'
													+ item.productCategoryid
													+ '">'
													+ item.productCategoryName
													+ '</option>';

										});

								$('#producte-category').html(tempCategoryHtml);
							}

						});

			}

			$('#submit').click(function() {
				var product = {};
				if (isEdit) {
					product.productId = productId;

				}
				product.productName = $('#shop-name').val();
				product.productDesc = $('#shop-desc').val();
				product.priority = $('#priority').val();
product.productCategory={productCategoryid : $('#producte-category').find('option').not(function() {
									return !this.selected;

								}).data('id')};
				var productImg = $('#producte-img')[0].files[0];
 product.normalPrice=$('#normal').find('option').not(function() {
									return !this.selected;

								}).data('value');
				var formData = new FormData();
				formData.append('productStr', JSON.stringify(product));
				formData.append("thumbnail", productImg);
			$('.detail-img').map(
						function(index, item) {
							if ($('.detail-img')[index].files.length > 0) {
								var ims=$('.detail-img')[index].files[0]
								formData.append('productimg' + index,
										ims);
							
							
										
								console.log('s');		
							}
						});

				$.ajax({
							url : (isEdit ? updateProduct : addProduct),
							type : 'POST',
							data : formData,
							contentType : false,
							processData : false,
							cache : false,
							success : function(data) {
								if (data.success) {
									$.toast('提交成功');

								} else {

									$.toast('提交失败');
								}

							}
						});

			});

			$('.detail-img').click(function() {

						if (num < index) {
							imghtml = ' <input type="file" class="detail-img">';

							$('#detailimg').append(imghtml);

							num1 = num1 + 1;
							num = num1;
						}

					});

		});