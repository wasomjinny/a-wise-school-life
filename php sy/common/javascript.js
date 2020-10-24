
var is_ie = (navigator.appName == "Microsoft Internet Explorer") ? true : false;

function get_timestamp() {
	var d = new Date();
	return (d.getTime()/1000).toFixed();
}
/*
document.onfocusin = function() {
	var tagName = event.srcElement.tagName;
	if(tagName == 'A' || tagName == 'IMG') document.body.focus();
}
*/
function toggle_display(obj_id,offsetx,offsety) {
	var len = toggle_display.arguments.length;
	var obj = document.getElementById(obj_id);

	if(obj) {
		if(obj.style.display == 'none') {
			if(len > 1) {
				offsetx += (event) ? event.x : 0;
				if(len > 2) offsety += (event) ? event.y : 0;
				obj.style.left = offsetx;
				obj.style.top = offsety;
			}
			obj.style.display = 'block';
		}
		else {
			obj.style.display = 'none';
		}
	}
}
function toggle_layer(obj_id,offsetx,offsety) {
	var len = toggle_layer.arguments.length;
	var obj = document.getElementById(obj_id);
	if(obj) {
		if(obj.style.display == 'block' || obj.style.display == '') {
			obj.style.display = 'none';
		}
		else {
			if(len > 1) {
				offsetx += (event) ? event.x : 0;
				if(len > 2) offsety += (event) ? event.y : 0;
				obj.style.left = offsetx;
				obj.style.top = offsety;
			}
			obj.style.display = 'block';
		}
	}
}
function show_layer(obj_id,offsetx,offsety) {
	var len = show_layer.arguments.length;
	var obj = document.getElementById(obj_id);
	if(obj) {
		if(obj.style.display == 'none') {
			if(len > 1) {
				offsetx += (event) ? event.x : 0;
				if(len > 2) offsety += (event) ? event.y : 0;
				obj.style.left = offsetx;
				obj.style.top = offsety;
			}
			obj.style.display = 'block';
		}
	}
}
function hide_layer(obj_id) {
	var obj = document.getElementById(obj_id);
	if(obj) obj.style.display = 'none';
}
function image_on_error() {
	var obj = event.srcElement;
	obj.src = "/img/1x1.gif";
}

// 아래 부분 파트너 페이지에서 인클루드시 오류가 나서 주석처리합니다.
// 혹시 주석처리로 인해 오류가 나면 이 부분 주석 해제하시고 저한테 얘기만 해주세요.
// 2010.12.23, 김기완
/*
document.write('<div id="DivNewTagTitle">DivNewTagTitle</div>');
with(DivNewTagTitle.style) {position='absolute';padding='2px';border='1px solid black';backgroundColor='#FFFFDE';color='#000000';display='none';zIndex='100';width='auto';height='auto';}
function TitleToDiv(offsetx) {
	if(!document.all) return;
	this.Style = DivNewTagTitle.style;
	var BaseArgs = arguments;
	this.Apply = function()
	{
		var TagNames = BaseArgs.length ? BaseArgs : Array('a');
		for(var i=1; i<TagNames.length; i++)
		{
			var TagObjects = document.getElementsByTagName(TagNames[i]);
			for(var k=0; k<TagObjects.length; k++) {
				if(TagObjects[k].getAttribute('title'))
				{
					var SavedTitle;
					TagObjects[k].onmouseover = function()
					{
						with(DivNewTagTitle) {
							style.display = 'block';
							innerHTML = this.title;
							SavedTitle = this.title;
							this.title = '';
							var X = event.x + document.body.scrollLeft;
							var Y = event.y + document.body.scrollTop;
							style.left = X + 5 - offsetx;
							style.top = Y + 5;
						}
					}
					TagObjects[k].onmouseout = function()
					{
						DivNewTagTitle.style.display = 'none';
						this.title = SavedTitle;
					}
				}
			}
		}
	}
};
*/

function content_view(todo,no) {
	if(todo == "product") {
		window.open("../product/product_view.php?product_no="+no);
	}
	else if(todo == "golf") {
		window.open("../golf/golf_view.php?golf_no="+no);
	}
	else if(todo == "golf_rest") {
		window.open("../golf/golf_rest.php?menu=rest&golf_no="+no);
	}
	else if(todo == "hotel") {
		window.open("../hotel/hotel_view.php?hotel_no="+no);
	}
	else if(todo == "poi") {
		window.open("../poi/poi_view.php?poi_no="+no);
	}
	else if(todo == "place") {
		window.open("../place/place_view.php?place_no="+no);
	}
	else if(todo == "users") {
		window.open("../user/user_view.php?user_no="+no);
	}
	else if(todo == "image") {
		popup_image_view(no);
	}
	else if(todo == 'location') {
		window.open('../location/location_view.php?location_no='+no);
	}
	else {
		return;
	}
}
function bookmark_open(obj) {
	var url = obj.options[obj.selectedIndex].value;
	if(url == '') { obj.selectedIndex = 0; return; }
    window.open(url);
	obj.selectedIndex = 0;
}
function style_toggle(obj, cls, str) {
	if(str) {
		if(obj.value == "") obj.value = str;
		else if(obj.value == str) obj.value = "";
	}
	obj.className = cls;
}
function init_select_box(obj, val) {
	if(val == "") return;
	if(obj != null && obj != "") {
		for(var i=0; i<obj.length; i++) {
			if(obj.options[i].value == val) {
				obj.options[i].selected = true;
			}
		}
	}
}
function init_code_array_select(obj,arr,val) {
	var len = obj.length;
	for(var i=0; i<arr.length; i++) {
		obj.options[i+len] = new Option(arr[i][2],arr[i][1]);
	}
	if(val != null && val != "" && val != "0") {
		init_select_box(obj,val);
	}
}
function init_radio(obj, val) {
	if(obj) {
		for(var i=0; i<obj.length; i++) {
			if(obj[i].value == val) {
				obj[i].checked = true;
			}
		}
	}
}
function get_radio_value(obj) {
	var len = obj.length;
	var val = "";
	for(i=0; i<len; i++) { if(obj[i].checked) { val = obj[i].value; break; } }
	return val;
}
function init_check_box(obj, val, deli) {
	if(obj) {

		var i,j,k;
		var obj_len = obj.length;
		var val_len = val.length;
		var arr;
		var arr_len;
		if(deli) {
			arr = val.split(deli);
			arr_len = arr.length;
		}
		for(i=0; i<obj_len; i++) {
			if(deli) {
				for(k=0; k<arr_len; k++) {
					if(obj[i].value == arr[k]) {
						obj[i].checked = true;
					}
				}
			}
			else {
				for(j=0; j<val_len; j++) {
					if(obj[i].value == val.charAt(j)) {
						obj[i].checked = true;
					}
				}
			}
		}
	}
}
function init_code_array_checkbox(div,chkname,arr,val) {
	var html = '';
	var vals = (val == '') ? '' : val.split(",");
	var checked = '';
	for(i=0; i<arr.length; i++) {
		checked = '';
		for(j=0; j<vals.length; j++) if(checked == '') checked = (arr[i][1] == vals[j]) ? 'checked' : '';
		html += "<input type='checkbox' name='"+chkname+"' value='"+arr[i][1]+"' "+checked+">"+arr[i][2]+" ";
	}
	div.innerHTML = html;
}
function get_code_array_name(div,arr,val) {
	var html = '';
	for(i=0; i<arr.length; i++) {
		if(arr[i][1] == val) html = arr[i][2];
	}
	div.innerHTML = html;
}
function get_code_array_names(div,arr,val,delimiter) {
	var html = '';
	var str = '';
	var vals = (val == '') ? '' : val.split(",");
	for(i=0; i<arr.length; i++) {
		str = '';
		for(j=0; j<vals.length; j++) {
			if(str == '') if(arr[i][1] == vals[j]) str = (i == (arr.length-1)) ? arr[i][2] : arr[i][2] + delimiter;
		}
		html += str;
	}
	div.innerHTML = html;
}
function toggle_checkbox(obj) {
	if(obj) {
		var tf = false;
		var src = (event) ? event.srcElement : null;
		tf = (src != null) ? src.checked : obj[0].checked;
		if(obj.length) {
			var len = obj.length;
			for(i=0; i<len; i++) obj[i].checked = tf;
		}
		else {
			obj.checked = tf;
		}
	}
}
function textarea_resize(obj,min_height) {
	var scroll_height = obj.scrollHeight;
	if(scroll_height >= min_height) obj.style.pixelHeight = scroll_height + 4;
}
function td_resize(td, iframe) {
	if(td == null || td == "" || td == "undefined" || iframe == null || iframe == "" || iframe == "undefined") return;
	td.style.width = iframe.document.body.scrollWidth;
	td.style.height = iframe.document.body.scrollHeight;
}
function iframe_resize(obj) {
	var obj_body = obj.document.body;
	var obj_iframe = document.getElementById(obj.name+"");
	obj_iframe.style.height = obj_body.scrollHeight;
}
function move_focus(src, cnt, tar) {
	if(src.value.length == cnt) {
		tar.focus();
	}
}
function str_len(str) {
	return(str.length+(escape(str)+"%u").match(/%u/g).length-1);
}
function show_str_len(obj, obj_count) {
	if(obj) obj_count.value = str_len(obj.value);
}
function tr_over(obj, backgroundColor) {
	if(!backgroundColor || backgroundColor == null || backgroundColor == "") {
		backgroundColor = '#ffff99';
	}
	obj.style.backgroundColor = backgroundColor;

}

function tr_out(obj, backgroundColor) {
	if(!backgroundColor || backgroundColor == null || backgroundColor == "") {
		backgroundColor = '';
	}
	obj.style.backgroundColor = backgroundColor;

}
function td_over(obj, backgroundColor) {
	if(!backgroundColor || backgroundColor == null || backgroundColor == "") {
		backgroundColor = '#ffcc66';
	}
	obj.style.backgroundColor = backgroundColor;

}

function td_out(obj, backgroundColor) {
	if(!backgroundColor || backgroundColor == null || backgroundColor == "") {
		backgroundColor = '';
	}
	obj.style.backgroundColor = backgroundColor;

}
function rowspan(table_id, column_no) {
//	var obj = document.getElementById(table_id);
	var obj = document.getElementById(table_id);
	if(obj == null) return;
	var rows = obj.getElementsByTagName("TR");
	var previous = -1;
	for(var i=0; i<rows.length; i++) {
		if(i > 0) {
			var compare = (previous < 0) ? (i - 1) : previous ;
			var preCol = rows[ compare ].getElementsByTagName("TD")[column_no];
			var curCol = rows[i].getElementsByTagName("TD")[column_no];
			if (preCol.innerHTML == curCol.innerHTML){
				preCol.rowSpan = preCol.rowSpan + 1;
				curCol.style.display = 'none';
				previous = compare;
			}
			else{
				previous = -1;
			}
		}
	}
}
function remove_blank(str) {
	return str.replace(/\s/g,'');
}
function korean_only() {
	if((event.keyCode < 12592) || (event.keyCode > 12687)) {
		event.returnValue = false;
	}
}
function to_upper_case(obj) {
	var key = event.keyCode;
	if(key == 9 || key == 16 || key == 37 || key == 38 || key == 39 || key == 40 || key == 35 || key == 36) { obj.focus(); return; } // TAB, SHIFT, ARROW, HOME, END
	obj.value = obj.value.toUpperCase();
}

function time_format(obj) {
	var key = event.keyCode;
	if(key == 9 || key == 16 || key == 37 || key == 38 || key == 39 || key == 40 || key == 35 || key == 36) { obj.focus(); return; } // TAB, SHIFT, ARROW, HOME, END
	if(obj == null || obj.value == "") return;
	if(obj.value.length == 2) {
		if(event.keyCode == 8 || event.keyCode == 46) return; // BACKSPACE, DEL
		obj.value = obj.value + ":";
	}
}

function number_only() {
	var key = event.keyCode;
	var val = event.srcElement.value;
	//alert(key);
	if(val != "") {
		if(key == 35 || key == 36 || key == 37 || key == 38 || key == 39 || key == 40) { // HOME, END, LEFT, UP, RIGHT, DOWN
		}
		//else if(key == 8 || key == 46 || key == 9 || key == 16) { // BACKSPACE, DEL, TAB, SHIFT
		//}
		else if(key == 107 || key == 109 || key == 189 || key == 187 || key == 110) { // -, +, .
		}
		else {
			var prefix = "";
			prefix = val.charAt(0);

			if(prefix == "+" || prefix == "-") {
				val = val.substr(0,val.length);
			}
			else {
				prefix = "";
			}
			if(val.indexOf(".") != -1) {
			}

			val = val.replace(/[^0-9.]/gi,"");
			var len = val.length;
			var result = "";
			for(var i=0; i<len; i++) {
				var tmp = len-(i+1);
				if(i%3==0 && i!=0) result = "," + result;
				result = val.charAt(tmp) + result;
			}
			event.srcElement.value = prefix + result;
		}
	}
}
function english_only() {
	var obj = event.srcElement;
	var str = obj.value;
	var chr = '';
	for(var i=0; i<str.length; i++) {
		chr = str.substr(i,1).toLowerCase();
		if((chr < 'a' || chr > 'z') && (chr !='_') && (chr !=' ')) {
			obj.value = str.replace(chr,'');
			obj.focus();
			return;
		}
	}
}
function number_english_only() {
	var obj = event.srcElement;
	var str = obj.value;
	var chr = '';
	for(var i=0; i<str.length; i++) {
		chr = str.substr(i,1).toLowerCase();
		if(((chr < '0' || chr > '9') && (chr < 'a' || chr > 'z')) && (chr !='_')) {
			obj.value = str.replace(chr,'');
			obj.focus();
			return;
		}
	}
}
function set_comma(obj) {
	var key;

   if(typeof(obj) != "undefined")
        key = obj.which;
    else
        key = event.keyCode;

	//var key = event.keyCode;
	if(key == 35 || key == 36 || key == 37 || key == 38 || key == 39 || key == 40) { // HOME, END, LEFT, UP, RIGHT, DOWN
	}
	else if(key == 8 || key == 46 || key == 9 || key == 16) { // BACKSPACE, DEL, TAB, SHIFT
	}
	else {
		if(obj.value != '') {
			var num = obj.value;
			num = num.replace(/,/g, "");
			var num_str = num.toString();
			var result = "";
			for(var i=0; i<num_str.length; i++) {
				var tmp = num_str.length-(i+1);
				if(i%3==0 && i!=0) result = "," + result;
				result = num_str.charAt(tmp) + result;
			}
			obj.value = result;
		}
	}
}
function intval(str) {
	return (str == "" || str == null) ? 0 : parseInt(str.replace(/,/g,""),10);
}
function floatval(str) {
	return (str == "" || str == null) ? 0.0 : parseFloat(str.replace(/,/g,""));
}
function date_format(str) {
	if(str.length == 8) {
		return str.substr(0,4)+"."+str.substr(4,2)+"."+str.substr(6,2);
	}
}
function time_format(str) {
	if(str.length == 4) {
		return str.substr(0,2)+":"+str.substr(2,2);
	}
}
function number_format(obj) {
	var num = (obj.value) ? obj.value : obj;
	if(num == null || num == '') {
		return 0;
	}
	else {
		temp=new String(num);
		if(temp.length<1) return "";

		if(temp.substr(0,1)=="-") minus="-";
		else minus="";

		dpoint=temp.search(/\./);

		if(dpoint>0)
		{
		dpointVa="."+temp.substr(dpoint).replace(/\D/g,"");
		temp=temp.substr(0,dpoint);
		}else dpointVa="";

		temp=temp.replace(/\D/g,"");
		zero=temp.search(/[1-9]/);

		if(zero==-1) return "";
		else if(zero!=0) temp=temp.substr(zero);

		if(temp.length<4) return minus+temp+dpointVa;
		buf="";
		while (true)
		{
		if(temp.length<3) { buf=temp+buf; break; }
		buf=","+temp.substr(temp.length-3)+buf;
		temp=temp.substr(0, temp.length-3);
		}
		if(buf.substr(0,1)==",") buf=buf.substr(1);

		if(obj.value) {
			obj.value = minus+buf+dpointVa;
		}
		else {
			return minus+buf+dpointVa;
		}
	}
}
function br2nl(s) {
	if(!s) return '';
	return is_ie ? s.replace(/<br\s*\/?>/ig,'\n') : s.replace(/<br\s*\/?>/ig,'');
}
function html_encode(s) {
	if(!s) return '';
	return s.replace(/\</ig,'&lt;').replace(/\>/ig,'&gt;').replace(/([^>])\n/g,'$1<br />\n');
}
function html_decode(s) {
	if(!s) return '';
	var t = is_ie ? s.replace(/<br\s*\/?>/ig,'') : s.replace(/<br\s*\/?>/ig,'');
	t = br2nl(t);
	t = t.replace('&quot;','"');
	return t.replace(/\&gt\;/ig,'>').replace(/\&lt\;/ig,'<').replace(/\&amp\;/ig,'&');
}


function select_on_change(obj_name, obj_lg, arr_lg, obj_md, arr_md, obj_sm, arr_sm, obj_de, arr_de, obj_de_lg, arr_de_lg, obj_de_md, arr_de_md, obj_de_sm, arr_de_sm) {

	if(obj_name == obj_lg.name) {
		if(obj_md != null && obj_md != "" && arr_md != null && arr_md != "") {
			while(obj_md.length > 2) obj_md.options[2] = null;
			for(i=0,j=0; i<arr_md.length; i++) {
				if(arr_md[i][0] == obj_lg.value) {
					obj_md.options[j+2] = new Option(arr_md[i][2], arr_md[i][1]);
					j++;
				}
			}
		}
		if(obj_sm != null && obj_sm != "") {
			while(obj_sm.length > 2) obj_sm.options[2] = null;
		}
		if(obj_de != null && obj_de != "") {
			while(obj_de.length > 2) obj_de.options[2] = null;
		}

		if(obj_de_lg != null && obj_de_lg != "") {
			while(obj_de_lg.length > 2) obj_de_lg.options[2] = null;
		}
		if(obj_de_md != null && obj_de_md != "") {
			while(obj_de_md.length > 2) obj_de_md.options[2] = null;
		}
		if(obj_de_sm != null && obj_de_sm != "") {
			while(obj_de_sm.length > 2) obj_de_sm.options[2] = null;
		}
	}
	if(obj_md != null && obj_md != "") {
		if(obj_name == obj_md.name) {
			if(obj_sm != null && obj_sm != "" && arr_sm != null && arr_sm != "") {
				while(obj_sm.length > 2) obj_sm.options[2] = null;

				for(i=0,j=0; i<arr_sm.length; i++) {
					if(arr_sm[i][0] == obj_md.value) {
						obj_sm.options[j+2] = new Option(arr_sm[i][2], arr_sm[i][1]);
						j++;
					}
				}
			}
			if(obj_de != null && obj_de != "") {
				while(obj_de.length > 2) obj_de.options[2] = null;
			}
			if(obj_de_lg != null && obj_de_lg != "") {
				while(obj_de_lg.length > 2) obj_de_lg.options[2] = null;
			}

			if(obj_de_md != null && obj_de_md != "") {
				while(obj_de_md.length > 2) obj_de_md.options[2] = null;
			}
			if(obj_de_sm != null && obj_de_sm != "") {
				while(obj_de_sm.length > 2) obj_de_sm.options[2] = null;
			}
		}

	}

	if(obj_sm != null && obj_sm != "") {
		if(obj_name == obj_sm.name) {
			if(obj_de != null && obj_de != "" && arr_de != null && arr_de != "") {
				while(obj_de.length > 2) obj_de.options[2] = null;

				for(i=0,j=0; i<arr_de.length; i++) {
					if(arr_de[i][0] == obj_sm.value) {
						obj_de.options[j+2] = new Option(arr_de[i][2], arr_de[i][1]);

						j++;
					}
				}
			}
			if(obj_de_lg != null && obj_de_lg != "") {
				while(obj_de_lg.length > 2) obj_de_lg.options[2] = null;
			}
			if(obj_de_md != null && obj_de_md != "") {
				while(obj_de_md.length > 2) obj_de_md.options[2] = null;
			}
			if(obj_de_sm != null && obj_de_sm != "") {
				while(obj_de_sm.length > 2) obj_de_sm.options[2] = null;
			}
		}

	}

	if(obj_de != null && obj_de != "") {
		if(obj_name == obj_de.name) {
			if(obj_de_lg != null && obj_de_lg != "" && arr_de_lg != null && arr_de_lg != "") {

				while(obj_de_lg.length > 2) obj_de_lg.options[2] = null;

				for(i=0,j=0; i<arr_de_lg.length; i++) {
					if(arr_de_lg[i][0] == obj_de.value) {
						obj_de_lg.options[j+2] = new Option(arr_de_lg[i][2], arr_de_lg[i][1]);
						j++;
					}
				}
			}

			if(obj_de_md != null && obj_de_md != "") {
				while(obj_de_md.length > 2) obj_de_md.options[2] = null;
			}
			if(obj_de_sm != null && obj_de_sm != "") {
				while(obj_de_sm.length > 2) obj_de_sm.options[2] = null;
			}

		}
	}

	if(obj_de_lg != null && obj_de_lg != "") {
		if(obj_name == obj_de_lg.name) {
			if(obj_de_md != null && obj_de_md != "" && arr_de_md != null && arr_de_md != "") {
				while(obj_de_md.length > 2) obj_de_md.options[2] = null;

				for(i=0,j=0; i<arr_de_md.length; i++) {
					if(arr_de_md[i][0] == obj_de_lg.value) {

						obj_de_md.options[j+2] = new Option(arr_de_md[i][2], arr_de_md[i][1]);
						//alert(arr_de_md[i][1]);break;
						j++;
					}
				}
			}
			if(obj_de_sm != null && obj_de_sm != "") {
				while(obj_de_sm.length > 2) obj_de_sm.options[2] = null;
			}

		}
	}

	if(obj_de_md != null && obj_de_md != "") {
		//alert(obj_de.value)
		if(obj_name == obj_de_md.name) {
			if(obj_de_sm != null && obj_de_sm != "" && arr_de_sm != null && arr_de_sm != "") {
				while(obj_de_sm.length > 2) obj_de_sm.options[2] = null;

				for(i=0,j=0; i<arr_de_sm.length; i++) {
					if(arr_de_sm[i][0] == obj_de_md.value) {
						obj_de_sm.options[j+2] = new Option(arr_de_sm[i][2], arr_de_sm[i][1]);
						j++;
					}
				}
			}

		}
	}

}

function select_on_checkbox_change(obj_name, obj_lg, arr_lg, obj_md, arr_md, obj_sm_name, arr_sm, sm_value, inherit_yn) {

	if(obj_name == obj_lg.name) {
		if(obj_md != null && obj_md != "" && arr_md != null && arr_md != "") {
			while(obj_md.length > 2) obj_md.options[2] = null;
			for(i=0,j=0; i<arr_md.length; i++) {
				if(arr_md[i][0] == obj_lg.value) {
					obj_md.options[j+2] = new Option(arr_md[i][2], arr_md[i][1]);
					j++;
				}
			}
		}
	}
	if(obj_md != null && obj_md != "") {
		if(obj_name == obj_md.name) {

			if(arr_sm != null && arr_sm != "") {

				if(sm_value) {
					var deli = ',';

					var arr = sm_value.split(',');
					var arr_len = arr.length;
				}

				if(obj_sm_name=='category_sm_no') {
					var cate_chk = document.getElementById("cate_chk");
				} else if(obj_sm_name=='category2_sm_no') {
					var cate_chk = document.getElementById("cate_chk2");
				}


				cate_chk.innerHTML = "";

				var this_chk = "<tr>";

				for(i=0,j=0; i<arr_sm.length; i++) {
					if(arr_sm[i][0] == obj_md.value) {



						var checked = '';
						var inherit_yn = 'N';
						var this_style = 'color:black;';

						if(sm_value) {
							for(k=0; k<arr_len; k++) {
								var arr2 = arr[k].split(':');

								if(arr_sm[i][1] == arr2[0]) {

									inherit_yn = arr2[1];

									if(inherit_yn=='Y') {
										this_style = 'color:green;font-weight:900;';
										checked = 'checked';
									} else if(inherit_yn=='C') {
										this_style = 'color:blue;font-weight:900;';
										checked = '';
									} else {
										this_style = 'color:black;';
										checked = 'checked';
									}
									break;
								}
							}
						}

						if(j%7==0) this_chk += "</tr><tr>";

						if(obj_sm_name=='category_sm_no') {

							this_chk += "<td>";
							this_chk += "<label><input type='hidden' name='inherit_yn["+arr_sm[i][1]+"]' value='"+inherit_yn+"'><input type='checkbox' name='category_sm_no[]' value='"+arr_sm[i][1]+"' "+checked+"><span style='"+this_style+"'>"+arr_sm[i][2]+"<span></label>";

							this_chk+= "</td>";
						} else if(obj_sm_name=='category2_sm_no') {
							this_chk += "<td>";
							this_chk += "<label><input type='hidden' name='inherit_yn["+arr_sm[i][1]+"]' value='"+inherit_yn+"'><input type='checkbox' name='category2_sm_no[]' value='"+arr_sm[i][1]+"' "+checked+"><span style='"+this_style+"'>"+arr_sm[i][2]+"<span></label>";

							this_chk+= "</td>";
						}
						j++;
					}
				}

				this_chk += "</tr>";

				console.log(this_chk);

				cate_chk.innerHTML += this_chk;

			}
		}
	}
}

function init_select_cate(lg_arr,lg_obj,lg_value,md_arr,md_obj,md_value,sm_arr,sm_obj_name,sm_value) {

	for(var i=0; i<lg_arr.length; i++) {
		lg_obj.options[i+2] = new Option(lg_arr[i][2],lg_arr[i][1]);
	}
	if(lg_value != "" && lg_value != "0") {
		init_select_box(lg_obj, lg_value);
		select_on_change(lg_obj.name,lg_obj,lg_arr,md_obj,md_arr);

		if(md_value != "" && md_value != "0") {
			init_select_box(md_obj, md_value);


			select_on_checkbox_change(md_obj.name,lg_obj,lg_arr,md_obj,md_arr,sm_obj_name,sm_arr, sm_value);


		}
	}
}


function init_select(lg_arr,lg_obj,lg_value,md_arr,md_obj,md_value,sm_arr,sm_obj,sm_value,de_arr,de_obj,de_value,de_lg_arr,de_lg_obj,de_lg_value) {
	for(var i=0; i<lg_arr.length; i++) {
		lg_obj.options[i+2] = new Option(lg_arr[i][2],lg_arr[i][1]);
	}
	if(lg_value != "" && lg_value != "0") {
		init_select_box(lg_obj, lg_value);
		select_on_change(lg_obj.name,lg_obj,lg_arr,md_obj,md_arr,sm_obj,sm_arr,de_obj,de_arr);

		if(md_value != "" && md_value != "0") {
			init_select_box(md_obj, md_value);
			select_on_change(md_obj.name,lg_obj,lg_arr,md_obj,md_arr,sm_obj,sm_arr,de_obj,de_arr);

			if(sm_value != "" && sm_value != "0") {
				init_select_box(sm_obj, sm_value);
				select_on_change(sm_obj.name,lg_obj,lg_arr,md_obj,md_arr,sm_obj,sm_arr,de_obj,de_arr);

				if(de_value != "" && de_value != "0") {
					init_select_box(de_obj, de_value);
				}
			}
		}
	}
}
function init_select2(lg_arr,lg_obj,lg_value,md_arr,md_obj,md_value,sm_arr,sm_obj,sm_value,de_arr,de_obj,de_value,de_lg_arr,de_lg_obj,de_lg_value,de_md_arr,de_md_obj,de_md_value,de_sm_arr,de_sm_obj,de_sm_value) {

	for(var i=0; i<lg_arr.length; i++) {
		lg_obj.options[i+2] = new Option(lg_arr[i][2],lg_arr[i][1]);
	}
	if(lg_value != "" && lg_value != "0") {
		init_select_box(lg_obj, lg_value);
		select_on_change(lg_obj.name,lg_obj,lg_arr,md_obj,md_arr,sm_obj,sm_arr,de_obj,de_arr,de_lg_obj,de_lg_arr,de_md_obj,de_md_arr,de_sm_obj,de_sm_arr);

		if(md_value != "" && md_value != "0") {
			init_select_box(md_obj, md_value);
			select_on_change(md_obj.name,lg_obj,lg_arr,md_obj,md_arr,sm_obj,sm_arr,de_obj,de_arr,de_lg_obj,de_lg_arr,de_md_obj,de_md_arr,de_sm_obj,de_sm_arr);

			if(sm_value != "" && sm_value != "0") {
				init_select_box(sm_obj, sm_value);
				select_on_change(sm_obj.name,lg_obj,lg_arr,md_obj,md_arr,sm_obj,sm_arr,de_obj,de_arr,de_lg_obj,de_lg_arr,de_md_obj,de_md_arr,de_sm_obj,de_sm_arr);

				if(de_value != "" && de_value != "0") {
					init_select_box(de_obj, de_value);
					select_on_change(de_obj.name,lg_obj,lg_arr,md_obj,md_arr,sm_obj,sm_arr,de_obj,de_arr,de_lg_obj,de_lg_arr,de_md_obj,de_md_arr,de_md_obj,de_sm_obj,de_sm_arr);

					if(de_lg_value != "" && de_lg_value != "0") {
						init_select_box(de_lg_obj, de_lg_value);
						select_on_change(de_lg_obj.name,lg_obj,lg_arr,md_obj,md_arr,sm_obj,sm_arr,de_obj,de_arr,de_lg_obj,de_lg_arr,de_md_obj,de_md_arr,de_sm_obj,de_sm_arr);

						if(de_md_value != "" && de_md_value != "0") {
							init_select_box(de_md_obj, de_md_value);
							select_on_change(de_md_obj.name,lg_obj,lg_arr,md_obj,md_arr,sm_obj,sm_arr,de_obj,de_arr,de_lg_obj,de_lg_arr,de_md_obj,de_md_arr,de_sm_obj,de_sm_arr);

							if(de_sm_value != "" && de_sm_value != "0") {
								init_select_box(de_sm_obj, de_sm_value);
								select_on_change(de_sm_obj.name,lg_obj,lg_arr,md_obj,md_arr,sm_obj,sm_arr,de_obj,de_arr,de_lg_obj,de_lg_arr,de_md_obj,de_md_arr,de_sm_obj,de_sm_arr);
							}
						}
					}
				}
			}
		}
	}
}
function is_empty_html(s) {
	return (s.replace(/\<P\>\&nbsp\;\<\/P\>/g,'') == '') ? true : false;
}
function inline_edit_start(div,cmd) {
	var tagName = event.srcElement.tagName;
	if(tagName == 'A') return;
	var d = document.getElementById(div);
	var c = document.getElementById(cmd);
	d.contentEditable = true;
	d.className = 'inline_editor_active';
	c.style.display = 'block';
}
function inline_edit_save(tarea,div) {
	var d = document.getElementById(div);
	tarea.value = d.innerHTML;
	tarea.form.submit();
}
function inline_edit_cancel(tarea,div,cmd) {
	var d = document.getElementById(div);
	var c = document.getElementById(cmd);
	d.innerHTML = tarea.value;
	d.contentEditable = false;
	d.className = 'inline_editor_inactive';
	c.style.display = 'none';
}
function get_window_height() {
	if(window.self && self.innerHeight) return self.innerHeight;
	if(document.documentElement && document.documentElement.clientHeight) return document.documentElement.clientHeight;
	if(document.all) return document.body.offsetHeight;
	return 0;
}
function center_window(width, height) {
	var left = (screen.width / 2) - (width / 2);
	var top = (screen.height / 2) - (height / 2) - 35;
	self.moveTo(left,top);
	self.resizeTo(width+10,height+58);
}
function show_modal(url,title,width,height) {
	showModelessDialog(url+'&time=111','','dialogWidth:'+width+'px;dialogHeight:'+height+'px;status=no;');
}
function win_open(url, title, width, height) {
	var left = (screen.availWidth / 2) - (width / 2);
	var top = (screen.availHeight / 2) - (height / 2) - 20;
	var win = window.open(url, title, "toolbar=no,menubar=no,status=yes,scrollbars=yes,resizable=yes,width="+width+",height="+height+",left="+left+",top="+top);
	win.focus();
	return win;
}
function popup_image_view(file_no) {
	var url = "/common/popup_image_view.php?file_no="+file_no;
	var width = 320;
	var height = 240;
	var left = (screen.availWidth / 2) - (width / 2);
	var top = (screen.availHeight / 2) - (height / 2) - 20;
	var win = window.open(url, "", "toolbar=no,menubar=no,scrollbars=yes,resizable=yes,width="+width+",height="+height+",left="+left+",top="+top);
	win.focus();
}
function popup_image_view2(file_no, table) {
	var url = "/common/popup_image_view.php?file_no="+file_no+"&table="+table;
	var width = 320;
	var height = 240;
	var left = (screen.availWidth / 2) - (width / 2);
	var top = (screen.availHeight / 2) - (height / 2) - 20;
	var win = window.open(url, "", "toolbar=no,menubar=no,scrollbars=yes,resizable=yes,width="+width+",height="+height+",left="+left+",top="+top);
	win.focus();
}
function popup_file_view(file_no) {
	var width = 320;
	var height = 240;
	var left = (screen.availWidth / 2) - (width / 2);
	var top = (screen.availHeight / 2) - (height / 2) - 20;
	var win = window.open("/common/file_view.php?file_no="+file_no,"","toolbar=no,menubar=no,scrollbars=yes,resizable=yes,width="+width+",height="+height+",left="+left+",top="+top);
	win.focus();
}
function popup_file_list(owner_name, owner_no) {
	win_open("/common/file.php?todo=list&owner_name="+owner_name+"&owner_no="+owner_no,"",320,240);
}
function popup_file_upload(mode,owner_name, owner_no,file_no) {
	//-----------------------------------------------
	// "table"이란 파라미터 이름 사용하면 403 발생
	//-----------------------------------------------
	win_open("/fuk/files/file_upload.php?mode="+mode+"&owner_name="+owner_name+"&owner_no="+owner_no+"&file_no="+file_no,"file_upload",510,480);
}
// Add by HIS 2009.09.08
function popup_file_upload2(table, field, no) {
	win_open("/common/file_upload2.php?table="+table+"&field="+field+"&no="+no,"",510,640);
}
/**
* 파일 업로드
*/
function popup_field_upload(table,field,no) {
	//-----------------------------------------------
	// "table"이란 파라미터 이름 사용하면 403 발생
	//-----------------------------------------------
	win_open("/common/field_upload.php?tbl="+table+"&fld="+field+"&pk_no="+no,"",640,160);
}
function file_delete(table, field, no) {
	if(confirm("삭제할까요?")) {
		var url = "/fuk/files/file_delete.php?table="+table+"&field="+field+"&no="+no;
		hidden_frame.location.href = url;
		//location.href = url;
	}
}
function popup_editor(content_object,content_length,after_edit) {
	var url = "/common/editor.php?content_object="+content_object+"&content_length="+content_length+"&after_edit="+after_edit;
	var width = 640;
	var height = 480;
	var left = (screen.availWidth / 2) - (width / 2);
	var top = (screen.availHeight / 2) - (height / 2) - 20;
	var win = window.open(url, "", "toolbar=no,menubar=no,scrollbars=yes,resizable=yes,width="+width+",height="+height+",left="+left+",top="+top);
	win.focus();
}
function popup_todo_edit(data_name, data_no) {
	win_open("/board/todo_edit.php?data_name="+data_name+"&data_no="+data_no,"",650,460);
}
function popup_zipcode(zip,addr,dong) {
	win_open("/common/zipcode.php?zip="+zip+"&addr="+addr+"&dong="+dong,"",540,420);
}
function popup_help(file_name) {
	win_open("/common/help.php?file_name="+file_name,'',800,600);
}
function popup_inout_edit(param) {
	win_open("/money/inout_edit.php?"+param,'',600,500);
}
function popup_data_name_edit(lang,owner_name,owner_no) {
	win_open("/common/data_name_edit.php?lang="+lang+"&owner_name="+owner_name+"&owner_no="+owner_no,'popup_data_name_edit',600,200);
}
function popup_data_name_multi_edit(owner_name,owner_no,table,field) {
	if(popup_data_name_multi_edit.arguments.length == 2) { table = ''; field = ''; }
	win_open("/common/data_name_multi_edit.php?owner_name="+owner_name+"&owner_no="+owner_no+"&table="+table+"&field="+field,'popup_data_name_multi_edit',760,340);
}
function popup_data_name_multi_edit_test(owner_name,owner_no,table,field) {
	if(popup_data_name_multi_edit_test.arguments.length == 2) { table = ''; field = ''; }
	win_open("/common/data_name_multi_edit_test.php?owner_name="+owner_name+"&owner_no="+owner_no+"&table="+table+"&field="+field,'popup_data_name_multi_edit',600,260);
}
function popup_data_text_edit(lang,owner_name,owner_no) {
	win_open("/common/data_text_edit.php?lang="+lang+"&owner_name="+owner_name+"&owner_no="+owner_no,'popup_data_text_edit',600,200);
}
function popup_data_text_multi_edit(owner_name,owner_no,table,field) {
	if(popup_data_text_multi_edit.arguments.length == 2) { table = ''; field = ''; }
	win_open("/common/data_text_multi_edit.php?owner_name="+owner_name+"&owner_no="+owner_no+"&table="+table+"&field="+field,'',880,780);
}
function popup_data_text_multi_edit_big(owner_name,owner_no,table,field,code_no,lang) {
	if(popup_data_text_multi_edit_big.arguments.length == 2) { table = ''; field = ''; }
	win_open("/common/data_text_multi_edit_big.php?owner_name="+owner_name+"&owner_no="+owner_no+"&code_no="+code_no+"&lang="+lang+"&table="+table+"&field="+field,'popup_data_text_edit_big',880,580);
}
function popup_data_clob_edit(owner_name,owner_no,owner_lang) {
	win_open("/common/data_clob_edit.php?owner_name="+owner_name+"&owner_no="+owner_no+"&owner_lang="+owner_lang,'popup_data_clob_edit',800,600);
}
function popup_place_search(obj_no, obj_name, name) {
	win_open("../place/popup_place_search.php?obj_no="+obj_no+"&obj_name="+obj_name+"&name="+encodeURI(name),"",800,600);
}
function popup_place_search_keypress(obj_no, obj_name, name) {
	if(event.keyCode == 13) { popup_place_search(obj_no, obj_name, name); event.keyCode = ''; }
}

function popup_gubun_search(obj_no, obj_name, name, gubun,flag) {
	var f = document.form_edit;
	if(!gubun) {
		var gubun = f.user_gubun.value;
	}
	if(gubun=='') {
		alert(arr_lang['1667']);//구분을 선택해주세요
		f.user_gubun.focus();
		return;
	}
	win_open("../user/popup_gubun_search.php?obj_no="+obj_no+"&obj_name="+obj_name+"&name="+encodeURI(name)+"&gubun="+gubun+"&flag="+flag,"",800,600);
}
function popup_gubun_search_keypress(obj_no, obj_name, name,flag) {
	if(event.keyCode == 13) { popup_gubun_search(obj_no, obj_name, name,flag); event.keyCode = ''; }
}


function popup_location_search(obj_no, obj_name, name) {
	win_open("../location/popup_location_search.php?obj_no="+obj_no+"&obj_name="+obj_name+"&name="+name,"",800,600);
}
function popup_location_search_keypress(obj_no, obj_name, name) {
	if(event.keyCode == 13) { popup_location_search(obj_no, obj_name, name); event.keyCode = ''; }
}
function popup_group_search(name) {
	win_open("../group/popup_group_search.php?name="+name,"",800,600);
}
function popup_member_search(obj_no, obj_name, name, from) {
	win_open("../member/popup_member_search.php?obj_no="+obj_no+"&obj_name="+obj_name+"&name="+name+"&from="+from,"",800,640);
}
function popup_member_search_keypress(obj_no, obj_name, name) {
	if(event.keyCode == 13) { popup_member_search(obj_no, obj_name, name); event.keyCode = ''; }
}
function popup_user_search(obj_no, obj_name, name, from) {
	name = name ? name : '';
	from = from ? from : '';
	win_open("../user/popup_user_search.php?obj_no="+obj_no+"&obj_name="+obj_name+"&name="+name+"&from="+from,"",1000,640);
}
function popup_user_search_keypress(obj_no, obj_name, name) {
	name = name ? name : '';
	if(event.keyCode == 13) { popup_user_search(obj_no, obj_name, name); event.keyCode = ''; }
}
function popup_request_user_search(name) {
	name = name ? name : '';
	win_open("../reservation/request_user_search.php?name="+name,"popuprequsersearch",1000,640);
}
function popup_request_user_search_keypress(name) {
	name = name ? name : '';
	if(event.keyCode == 13) { popup_request_user_search(name); event.keyCode = ''; }
}
function popup_user_edit(no,name) {
	win_open("../user/user_edit.php?popup=1&user_no="+no+"&name="+name,"",800,600);
}
function popup_product_search(name,is_folder,show_front,form_no,form_name) {
	win_open("../product/popup_product_search.php?name="+name+"&is_folder="+is_folder+"&show_front="+show_front+"&form_no="+form_no+"&form_name="+form_name,"",800,600);
}
function popup_product_search2(obj_no, obj_name, name) {
	win_open("../product/popup_product_search.php?obj_no="+obj_no+"&obj_name="+obj_name+"&name="+name,"",800,640);
}
function popup_product_search_keypress(obj_no, obj_name, name) {
	if(event.keyCode == 13) { popup_product_search2(obj_no, obj_name, name); event.keyCode = ''; }
}
function popup_product_select(obj_no, obj_name) {
	win_open("../product/popup_product_select.php?obj_no="+obj_no+"&obj_name="+obj_name,"",400,180);
}
function popup_product_ref_search(obj_no,obj_name,name) {
	win_open("../product/popup_product_ref_search.php?obj_no="+obj_no+"&obj_name="+obj_name+"&name="+name,"",800,600);
}
function popup_product_ref_search_keypress(obj_no,obj_name,name) {
	if(event.keyCode == 13) { popup_product_ref_search(obj_no,obj_name,name); event.keyCode = ''; }
}
function popup_hotel_search(obj_no,obj_name,name,opt) {
	opt = opt ? opt : '';
	win_open("../hotel/popup_hotel_search.php?obj_no="+obj_no+"&obj_name="+obj_name+"&name="+encodeURI(name)+'&opt='+opt,"",800,600);
}
function popup_hotel_search_keypress(obj_no,obj_name,name,opt) {
	if(event.keyCode == 13) { popup_hotel_search(obj_no,obj_name,name,opt); event.keyCode = ''; }
}
function popup_hotel_brand_search(obj_no,obj_name,name) {
	win_open("../hotel/popup_hotel_brand_search.php?obj_no="+obj_no+"&obj_name="+obj_name+"&name="+encodeURI(name),"",800,600);
}
function popup_hotel_brand_search_keypress(obj_no,obj_name,name) {
	if(event.keyCode == 13) { popup_hotel_brand_search(obj_no,obj_name,name); event.keyCode = ''; }
}

function popup_hotel_brand_search_frm(obj_no,obj_name,name,menu) {
	win_open("../hotel/popup_hotel_brand_search.php?obj_no="+obj_no+"&obj_name="+obj_name+"&name="+encodeURI(name)+"&menu="+menu,"",800,600);
}
function popup_hotel_brand_search_keypress_frm(obj_no,obj_name,name,menu) {
	if(event.keyCode == 13) { popup_hotel_brand_search(obj_no,obj_name,name,menu); event.keyCode = ''; }
}




function popup_hotel_room_search(hotel_no,obj_no,obj_name,name) {
	win_open("../hotel/popup_hotel_room_search.php?hotel_no="+hotel_no+"&obj_no="+obj_no+"&obj_name="+obj_name+"&name="+encodeURI(name),"",800,600);
}
function popup_poi_search(obj_no,obj_name,name) {
	win_open("../poi/popup_poi_search.php?obj_no="+obj_no+"&obj_name="+obj_name+"&name="+encodeURI(name),"",1100,700);
}
function popup_poi_search_keypress(obj_no,obj_name,name) {
	if(event.keyCode == 13) { popup_poi_search(obj_no,obj_name,name); event.keyCode = ''; }
}
function popup_golf_search(obj_no,obj_name,name) {
	win_open("../golf/popup_golf_search.php?obj_no="+obj_no+"&obj_name="+obj_name+"&name="+encodeURI(name),"",800,600);
}
function popup_golf_search_keypress(obj_no,obj_name,name) {
	if(event.keyCode == 13) { popup_golf_search(obj_no,obj_name,name); event.keyCode = ''; }
}
function popup_rentcar_search(obj_no1,obj_name1,obj_no2,obj_name2,name) {
	win_open("../rentcar/popup_rentcar_search.php?obj_no1="+obj_no1+"&obj_name1="+obj_name1+"&obj_no2="+obj_no2+"&obj_name2="+obj_name2+"&name="+encodeURI(name),"",800,600);
}
function popup_card_link(owner_name, owner_no) {
	win_open("../common/card_link.php?owner_name="+owner_name+"&owner_no="+owner_no,"",600,480);
}
function popup_search_selector_keypress(obj_no,obj_name,obj_title,keyword) {
	if(event.keyCode == 13) { popup_search_selector(obj_no,obj_name,obj_title,keyword); event.keyCode = ''; }
}
function popup_search_selector(obj_no,obj_name,obj_title,keyword) {
	win_open("../common/popup_search_selector.php?obj_no="+obj_no+"&obj_name="+obj_name+"&obj_title="+obj_title+"&keyword="+encodeURI(keyword),"",800,600);
}
/**
 * 골프장,호텔,POI 통합검색 및 선택을 위한 팝업 창
 * - /ad/stage_banner_radius.php 참조
 *
 * input_type : 데이터 선택을 위한 폼 형태 ("radio", "checkbox")
 * after_close: 데이터 선택 후 팝업 창 닫음 ("y")
 * include_latlng : 지도 좌표 포함 ("y")
 *
 * 결과: 팝업 창에서 부모창으로 함수 호출
 * - opener.after_popup_data_search(data_name,data_no,data_title,lat,lng); // input_type이 radio인 경우
 * - opener.after_popup_data_search(result); // input_type이 checkbox인 경우
 */
function popup_data_search(param) { // input_type=radio&after_close=&include_latlng=y
	win_open('/common/popup_data_search.php?'+param,'popup_data_search',960,700);
}
function popup_url_search(obj_no,obj_name,name) {
	obj_no = obj_no ? obj_no : '';
	obj_name = obj_name ? obj_name : '';
	name = name ? name : '';
	win_open("../map/popup_url_search.php?obj_no="+obj_no+"&obj_name="+obj_name+"&name="+encodeURI(name),"",800,600);
}
function popup_url_search_keypress(obj_no,obj_name,name) {
	obj_no = obj_no ? obj_no : '';
	obj_name = obj_name ? obj_name : '';
	name = name ? name : '';
	if(event.keyCode == 13) { popup_url_search(obj_no,obj_name,name); event.keyCode = ''; }
}
function popup_line_group_search(obj_no,obj_name,name) { // 교통 > 노선그룹 검색
	obj_no = obj_no ? obj_no : '';
	obj_name = obj_name ? obj_name : '';
	name = name ? name : '';
	win_open("../line/popup_line_group_search.php?obj_no="+obj_no+"&obj_name="+obj_name+"&name="+encodeURI(name),"",800,600);
}
function popup_bookmark_edit() {
	win_open("../common/bookmark.php","",980,640);
}
function popup_sms(todo,to) {
	win_open("../sms_email/sms_form.php?todo="+todo+"&to="+to,"popupsms",400,340);
}
function popup_email(todo,to) {
	win_open("../sms_email/email_form_attach.php?todo="+todo+"&to="+to,"popupemail",820,600);
}
function popup_sms2(todo,to) {
	win_open("../../sms_email/sms_form.php?todo="+todo+"&to="+to,"popupsms",400,340);
}
function popup_email2(todo,to) {
	win_open("../../sms_email/email_form_attach.php?todo="+todo+"&to="+to,"popupemail",820,600);
}
function popup_calendar(obj,y,m,d,flag,obj2) {
	obj = obj ? obj : '';
	y = y ? y : '';
	m = m ? m : '';
	d = d ? d : '';
	flag = flag ? flag : '';
	obj2 = obj2 ? obj2 : '';
	win_open("/common/calendar.php?obj="+obj+"&y="+y+"&m="+m+"&d="+d+"&flag="+flag+"&obj2="+obj2,"popupcalendar",600,395);
}
function popup_calendar2(obj,y,m,d,start_date,end_date) {
	obj = obj ? obj : '';
	y = y ? y : '';
	m = m ? m : '';
	d = d ? d : '';
	start_date = start_date ? start_date : '00000000';
	end_date = end_date ? end_date : '99999999';
	win_open("/common/calendar2.php?obj="+obj+"&y="+y+"&m="+m+"&d="+d+"&start_date="+start_date+"&end_date="+end_date,"popupcalendar2",680,450);
}
function popup_calendar_selector(input_name,input_value,date_limit) {
	input_name  = input_name ? input_name : '';
	input_value = input_value ? input_value : '';
	date_limit  = date_limit ? date_limit : '';
	win_open('/common/calendar_selector.php?input_name='+input_name+'&input_value='+input_value+'&date_limit='+date_limit,'popupcalendarselector',680,270);
}
function popup_template(code_no) {
	code_no = code_no ? code_no : '';
	win_open("../template/template_list.php?code_no="+code_no,'',1360,680);
}
function popup_map_browser(owner_name, owner_no) {
	var url = "http://www.worldtee.com/map/map_browser.php?owner_name="+owner_name+"&owner_no="+owner_no;
	var width = screen.availWidth-60;
	var height = screen.availHeight-120;
	var left = (screen.availWidth / 2) - (width / 2);
	var top = (screen.availHeight / 2) - (height / 2) - 40;
	var win = window.open(url, "MAP_BROWSER", "toolbar=no,menubar=no,resizable=yes,width="+width+",height="+height+",left="+left+",top="+top);
	win.focus();
}
function popup_map_pointer_(owner_name, owner_no) { // Old Map Pointer
	var url = "/map/map_pointer.php?owner_name="+owner_name+"&owner_no="+owner_no;
	var width = 900;
	var height = 700;
	var left = (screen.availWidth / 2) - (width / 2);
	var top = (screen.availHeight / 2) - (height / 2) - 40;
	var win = window.open(url, "MAP_POINTER", "toolbar=no,menubar=no,resizable=yes,width="+width+",height="+height+",left="+left+",top="+top);
}
function popup_map_pointer(owner_name, owner_no) { // New Map Pointer
	var url = "/map/point.php?owner_name="+owner_name+"&owner_no="+owner_no;
	var width = 1000;
	var height = 740;
	var left = (screen.availWidth / 2) - (width / 2);
	var top = (screen.availHeight / 2) - (height / 2) - 40;
	var win = window.open(url, "MAPPOINT", "toolbar=no,menubar=no,resizable=yes,width="+width+",height="+height+",left="+left+",top="+top);
}
function popup_exchange_rate() {
	win_open('../exchange/exchange_get.php','exchangerate',1100,180);
}
function popup_sns_setup(owner_name,owner_no) {
	if(!owner_name || !owner_no) { alert('Parameter missing.'); return; }
	win_open('/common/popup_sns_setup.php?owner_name='+owner_name+'&owner_no='+owner_no,'popupsnssetup',600,400);
}
//-----------------------------------
// 글자 이미지 업로드 팝업 창 열기
//-----------------------------------
function popup_data_image(data_name,data_no) {
	win_open('/common/data_image.php?data_name='+data_name+'&data_no='+data_no,'popup_data_image',680,600);
}
//---------------------------
// 다음 에디터 팝업 창 열기
//---------------------------
function popup_daum_editor(param) {
	win_open('/api/daum/daumeditor-7.3.17/popup_editor.php?'+param,'popup_daum_editor',800,700);
}
function data_link_setup(data_name,data_no) {
	win_open('../common/data_link_setup.php?data_name='+data_name+'&data_no='+data_no,'datalinksetup',1024,768);
}
function get_cookie_val(offset) {
	var endstr = document.cookie.indexOf (";", offset);
	if(endstr == -1) endstr = document.cookie.length;
	return unescape(document.cookie.substring(offset, endstr));
}
function get_cookie(name) {
	var arg = name + "=";
	var alen = arg.length;
	var clen = document.cookie.length;
	var i = 0;

	while(i < clen) {
		var j = i + alen;
		if(document.cookie.substring(i, j) == arg) return get_cookie_val(j);
		i = document.cookie.indexOf(" ", i) + 1;
		if(i == 0) break;
	}
	return null;
}
function set_cookie(name, value) {
	var someday = new Date("December 25, 9999");

	var argv = set_cookie.arguments;
	var argc = set_cookie.arguments.length;
	var expires = (2 < argc) ? argv[2] : someday;
	var path    = (3 < argc) ? argv[3] : "/";
	var domain  = (4 < argc) ? argv[4] : null;
	var secure  = (5 < argc) ? argv[5] : false;

	document.cookie = name + "=" + escape (value) +
		((expires == null) ? "" : ("; expires=" + expires.toGMTString())) +
		((path    == null) ? "" : ("; path=" + path)) +
		((domain  == null) ? "" : ("; domain=" + domain)) +
		((secure  == true) ? "; secure" : "");
}
/*
function trans(val,opt) {
	var f = document._form_trans;
	f.val.value = val;
	f.opt.value = opt;
	f.submit();
}
document.write("<form name='_form_trans' action='../common/trans.php' method='post' target='hidden_frame'>");
document.write("<input type='hidden' name='val' value=''>");
document.write("<input type='hidden' name='opt' value=''>");
document.write("</form>");
*/
function get_win_height() {
	var win_height = 0;
	if(self.innerHeight) win_height = self.innerHeight; // Standard browsers (Mozilla, Safari, etc.)
	else if(document.documentElement && document.documentElement.clientHeight) win_height = document.documentElement.clientHeight; // IE 6
	else if(document.body) win_height = document.body.clientHeight; // IE 5
	return win_height;
}
function show_screen(opacity) {
	var div = document.getElementById('screen');
	div.style.width = document.documentElement.scrollWidth+'px';
	div.style.height = document.documentElement.scrollHeight+'px';
	if(opacity) {
		opacity = 10;
		if(typeof(div.style.filter)=='string'){div.style.filter='alpha(opacity:'+opacity+')';}
		if(typeof(div.style.KHTMLOpacity)=='string'){div.style.KHTMLOpacity=opacity/100;}
		if(typeof(div.style.MozOpacity)=='string'){div.style.MozOpacity=opacity/100;}
		if(typeof(div.style.opacity)=='string'){div.style.opacity=opacity/100;}
	}
	div.style.visibility = 'visible';
}
function hide_screen() {
	document.getElementById('screen').style.visibility = "hidden";
}
function show_loading() {
	/*
	var div1 = document.createElement('div');
	div1.id = 'div1_show_loading';
	div1.style.zIndex = '998';
	div1.style.position = 'absolute';
	div1.style.left = '0px';
	div1.style.top = '0px';
	div1.style.width = document.body.scrollWidth + (document.body.offsetWidth - document.body.clientWidth) + 'px';
	div1.style.height = document.body.scrollHeight + (document.body.offsetHeight - document.body.clientHeight) + 'px';
	document.body.appendChild(div1);
	*/
	var div2 = document.createElement('div');
	var top = document.body.scrollTop ? document.body.scrollTop : document.documentElement.scrollTop;
	div2.id = 'div2_show_loading';
	div2.className = 'loading';
	div2.innerHTML = '&nbsp; Loading... &nbsp;';
	div2.style.top = (top+20)+'px';
	div2.style.left = '20px';
	div2.style.zIndex = '999';
	document.body.appendChild(div2);
}
function hide_loading() {
	var div = document.getElementById('div2_show_loading');
	if(div) {
		try {
			document.body.removeChild(div);
		}
		catch(e) {
		}
	}
}

function tClear(obj) {
	obj.value = '';
}

function getCookie(cookieName)
{
  	var search = cookieName + "=";
  	var cookie = document.cookie;

	if( cookie.length > 0 ) {
   		startIndex = cookie.indexOf( cookieName );
	   	if( startIndex != -1 ) {
    		startIndex += cookieName.length;
		    endIndex = cookie.indexOf( ";", startIndex );
		    if( endIndex == -1) endIndex = cookie.length;

		    return unescape( cookie.substring( startIndex + 1, endIndex ) );
   		} else {
		    return false;
   		}
  	} else {
	   	return false;
  	}
}

function setCookie(cookieName, cookieValue, expireDate)
{
  	var today = new Date();
  	if(expireDate == '') {
  		document.cookie = cookieName + "=" + escape( cookieValue ) + "; path=/;";
  	} else {
  		today.setDate( today.getDate() + parseInt( expireDate ) );
  		document.cookie = cookieName + "=" + escape( cookieValue ) + "; path=/; expires=" + today.toGMTString() + ";";
  	}
}

function deleteCookie(cookieName)
{
  	var expireDate = new Date();

	expireDate.setDate( expireDate.getDate() - 1 );
  	document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString() + "; path=/";
}

//------------------------------
// 인트라넷 공통 파일 삭제하기
//------------------------------
function intra_file_delete(no) {
	if(confirm('Delete?')) {
		show_loading();
		$.post('/common/intra_file_delete.php',{'no':no},function(response, status, xhr) {
			hide_loading();
			if(status == "error") {
				var msg = "Sorry but there was an error: ";
				alert(msg + xhr.status + " " + xhr.statusText);
			}
			else {
				$('#intra_file_'+no).remove();
			}
		});
	}
}

//-----------------------
// 파일서버의 파일 처리
//-----------------------
function do_file_server(todo,owner_name,owner_no,file_no) {
	if (todo == 'delete') {
		if(confirm(arr_lang['179'])) { // 삭제할까요?
			show_loading();
			$.post('/common/file_server.php',{'todo':todo,'owner_name':owner_name,'owner_no':owner_no,'file_no':file_no},function(response, status, xhr) {
				hide_loading();
				if(status == "error") {
					var msg = "Sorry but there was an error: ";
					alert(msg + xhr.status + " " + xhr.statusText);
				}
				else {
					$('#file_server_file_'+file_no).remove();
				}
			});
		}
	}
}

/**
 * 컨텐츠 관리를 사용하여 등록된 데이터를 팝업창으로 보기
 *
 * owner_name     : 소유자 이름 ('golf','hotel','poi')
 * owner_no       : 소유자 번호
 * root_no        : 탭 메뉴 번호
 * multi_group_no : 다중컨텐츠그룹 번호(객실그룹번호)
 * multi_no       : 다중컨텐츠 번호(객실번호)
 */
function cms_popup_view(owner_name,owner_no,root_no,multi_group_no,multi_no) {
	win_open('/cms/cms_popup_view.php?owner_name='+owner_name+'&owner_no='+owner_no+'&root_no='+root_no+'&multi_group_no='+multi_group_no+'&multi_no='+multi_no,'cms_popup_view',800,600);
}

/**
 * 데이터베이스 테이블의 필드 값 수정하기
 *
 * trigger : 사용자가 명령을 실행하기 위해 클릭한 객체 (버튼 등, 없으면 null)
 * table   : 대상 테이블 이름
 * field   : 대상 필드 이름
 * value   : 업데이트할 값
 * where   : 조건절
 */
function db_field_update(trigger,table,field,value,where) {
	var data = 'table='+table+'&field='+field+'&value='+value+'&where='+where;
	//alert(data);

	show_loading();
	if (trigger != null && typeof(trigger) == 'Object') trigger.disabled = false;

	$.ajax({type:'POST',url:'/common/db_field_update.php',data:data,
		success: function(result) {
			hide_loading();
			if (trigger != null && typeof(trigger) == 'Object') trigger.disabled = false;

			if (result == '200') {
				alert(arr_lang['321']); // 저장되었습니다.
			}
			else {
				alert(result);
			}
		},
		error: function(jqXHR, textStatus, errorThrown) {
			hide_loading();
			alert('Ajax Failed... '+jqXHR+'\n'+textStatus+'\n'+errorThrown+'\n\n- db_field_update()\n- /common/javascript.js ');
		},
		fail: function(jqXHR, textStatus) {
			alert ('Request failed: '+textStatus);
		}
	});
}

function nl2br(str, is_xhtml) {
	// http://kevin.vanzonneveld.net
	var breakTag = (is_xhtml || typeof is_xhtml === 'undefined') ? '<br ' + '/>' : '<br>'; // Adjust comment to avoid issue on phpjs.org display
	return (str + '').replace(/([^>\r\n]?)(\r\n|\n\r|\r|\n)/g, '$1' + breakTag + '$2');
}

/**
 * Return true if color is dark, false otherwise.
 * (C) 2008 Syronex / J.M. Rosengard
 **/
function isdark(color) {
	var colr = parseInt(color.substr(1), 16);
	return (colr >>> 16) // R
	+ ((colr >>> 8) & 0x00ff) // G
	+ (colr & 0x0000ff) // B
	< 500;
}
function parseRGB(Hex) {
    var Word = parseInt(Hex.replace(/^#/, ""), 16);
    var R = Word >> 16 & 0xff;
    var G = Word >> 8 & 0xff;
    var B = Word & 0xff;

    return "rgb(" + R + ", " + G + ", " + B + ")";
}

//LPAD('java', '0', 8);     // 0000java
function LPAD(s, c, n) {
  if (! s || ! c || s.length >= n) {
    return s;
  }
  var max = (n - s.length)/c.length;
  for (var i = 0; i < max; i++) {
    s = c + s;
  }
  return s;
}

//RPAD('java', '0', 9);     // java00000
function RPAD(s, c, n) {
  if (! s || ! c || s.length >= n) {
    return s;
  }
  var max = (n - s.length)/c.length;
  for (var i = 0; i < max; i++) {
    s += c;
  }
  return s;
}
function popup_this_img(table,file_no) {
	var url = "/common/popup_img.php?table="+table+"&file_no="+file_no;
	var width = 320;
	var height = 240;
	var left = (screen.availWidth / 2) - (width / 2);
	var top = (screen.availHeight / 2) - (height / 2) - 20;
	var win = window.open(url, "", "toolbar=no,menubar=no,scrollbars=yes,resizable=yes,width="+width+",height="+height+",left="+left+",top="+top);
	win.focus();
}


function hiddenToText() {	$("input[type='hidden']").each(function(){	this.type = 'text'	});	};

function textShowName() {
	$("input").each(function() {

		var name = $(this).attr('name');
		var id = $(this).attr('id');
		if (id)	name += '('+id+')';

		$(this).attr('title', name);

		var top = $(this).position().top; var left = $(this).position().left +5;
		if ($(this).attr('type') != 'text') left += 80;



		$(this).after(
			$("<span/>").css({'background-color':'#ffffff', 'top':top+'px','left':left+'px','position':'absolute','color':'red','font-weight':'bold'})
			.html( $(this).attr('name') )
		);
	});
}

function _show_()
{
	hiddenToText();
	textShowName();
}

// cls = 클래스명, frm = search form 명, input = 생성되는 소트 input 명,  val = 생성된 소트 value
function wrapSort(cls, frm, input, val)
{
	if (!frm) return false;
	if (!input) input = 'sort';
	if (!val) val = '';
	var el = $('.' + cls);
	var asc_id = 'asc_' + cls;
	var desc_id = 'desc_' + cls;
	var asc_str = " <a id='" + asc_id + "' style='cursor:pointer'>▼</a>";
	var desc_str = "<a id='" + desc_id + "' style='cursor:pointer'>▲</a>";

	el.html(el.html() + asc_str + desc_str);

	if ($('#'+input).length<1) $('#' + frm).append("<input type='hidden' name='"+input+"' id='"+input+"' value='"+val+"' />");

	$('#'+asc_id).live('click', function() {
		$('#'+input).val(asc_id);
		$('#'+frm).find('input[type=submit]').trigger('click');
	});
	$('#'+desc_id).live('click', function() {
		$('#'+input).val(desc_id);
		$('#'+frm).find('input[type=submit]').trigger('click');
	});
}


document.write('<iframe id="hidden_frame" name="hidden_frame" src="about:blank" frameborder="0" width="0" height="0" style="display:none"></iframe>');
