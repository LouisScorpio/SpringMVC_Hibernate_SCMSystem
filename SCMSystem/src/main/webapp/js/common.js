
//通过value匹配相关的text，并返回，如果匹配不到，直接返回value
function valueToText(array, value) {
	array = array.substring(1, array.length - 1);
	var sp = array.split(",");
	for ( var i = 0; i < sp.length; i++) {
		
		var array2 = sp[i].split("=","100");
		//alert("array2[0]" + array2[0]);
		//alert("value" + value);
		if ($.trim(array2[0]) == $.trim(value)) {
			return array2[1];
		}
	}
	
	return "类型没有定义";
}