$(function() {
			var shopId = getQueryString('shopId');
			var isEdit = shopId ? true : false;
			var initUrl = '/S2o/shopadmin/getshopinitinfo';
			var registerShopUrl = '/S2o/shopadmin/registershop';
			var shopInfoUrl = "/S2o/shopadmin/getshopbyid?shopId=" + shopId;
			var editShopUrl = '/S2o/shopadmin/modifyShop';
			if (isEdit==false) {
				getShopInitInfo();
			} else {
getShopInfo(shopId);
			}
			function getShopInfo(shopId) {
				$.getJSON(shopInfoUrl, function(data) {
							if (data.success) {
								var shop = data.shop;
								$('#shop-name').val(shop.shopName);
								$('#shop-addr').val(shop.shopAddr);
								$('#shop-phone').val(shop.phone);
								$('#shop-desc').val(shop.shopDesc);
								var temHtml = '';
								var tempAreaHtml = '';
								var shopCategory = '<option data-id="'
										+ shop.shopCategory.shopCategoryId
										+ '"selected>'
										+ shop.shopCategory.shopCategoryName
										+ '</option>';
								data.area.map(function(item, index) {
											tempAreaHtml += '<option data-id="'
													+ item.areaId + '">'
													+ item.areaName
													+ '</option>';

										});
								$('#shop-category').html(shopCategory);$('#shop-category')
										.attr('disabled', 'disabled');
								$('#area').html(tempAreaHtml);
								$("#area option[data-id='"+shop.area.areaId+"']").attr("selected","selected");
								
							} 

						});

			}
			function getShopInitInfo() {
				$.getJSON(initUrl, function(data) {
							if (data.success) {
								var tempHtml = '';
								var tempAreaHtml = '';
								data.shopCategoryList.map(
										function(item, index) {
											tempHtml += '<option data-id="'
													+ item.shopCategoryId
													+ '">'
													+ item.shopCategoryName
													+ '</option>';

										});
								$("#shop-category").html(tempHtml);
								data.areaList.map(function(item, index) {
											tempAreaHtml += '<option data-id="'
													+ item.areaId + '">'
													+ item.areaName
													+ '</option>';

										});

								$("#area").html(tempAreaHtml);

							}

						});
				$('#submit'). click(function() {
					var shop = {};
					if(isEdit){  
						shop.shopId=shopId;
						
					}
					shop.shopName = $('#shop-name').val();
					shop.shopAddr = $('#shop-addr').val();
					shop.phone = $('#shop-phone').val();
					shop.shopDesc = $('#shop-desc').val();
					shop.shopCategory = {
						shopCategoryId : $('#shop-category').find('option')
								.not(function() { 
										}).data('id')

					};
					shop.area = {
						areaId : $('#area').find('option').not(function() {
									return !this.selected;

								}).data('id')

					};
					var shopImg = $('#shop-img')[0].files[0];
					var formData = new FormData();
					formData.append('shopImg', shopImg);
					formData.append('shopStr', JSON.stringify(shop));
					$.ajax({
								url : (isEdit?editShopUrl:registerShopUrl),
								type : 'POST',
								data : formData,
								contentType : false,
								processData : false,
								cache : false,
								success : function(data) {
									if (data.success) {
										$.toast('提交成功');

									} else {

										$.toast('提交失败' + data.errMs);

									}

								}
							});
				});
			}

		});