$(function() {
			var shopId = getQueryString('shopId');
			var shopInfoUrl = '/S2o/shopadmin/getShopManagementInfo?shopId=' + shopId;
			$.getJSON(shopInfoUrl, function(data) {
						if (data.redirect) {
							window.location.href = data.url

						} else {
							if (data.shopId != undefined && data.shopId != null) {
								shopId = data.shopId;

							}
							$('#shopInfo').attr(
									'href',
									'/S2o/shopadmin/shopoperation?shopId='
											+ shopId);
						$('#productcategorymanage').attr(
									'href',
									'/S2o/shopadmin/commodityUnit?shopId='
											+ shopId);
											
						}

					});

		})