var J = jQuery.noConflict();
function tosortnum(i, i2) {
	i = i.toString()
	j = ''
	for ( var j2 = 0; j2 < i2 - i.length; j2++) {
		j = j + '0'
	}
	return j + i
}// tosortnum
function a(o) {
	if (typeof o != 'object') {
		alert(o)
	} else {
		alert(JSON.parse(o))
	}
}// a
function l(o) {
		console.log(o)
}// a
function replaceAll(Source,stringToFind,stringToReplace){
  var temp = Source;
    var index = temp.indexOf(stringToFind);
        while(index != -1){
            temp = temp.replace(stringToFind,stringToReplace);
            index = temp.indexOf(stringToFind);
        }
        return temp;
}

//androidandroidandroidandroidandroid
//androidandroidandroidandroidandroid
//androidandroidandroidandroidandroid
//androidandroidandroidandroidandroid
function get_scroll_position(func,uuid){
	obj={'position':document.body.scrollTop}
	AndroidInterfaceCall(func,uuid,obj)
}
function set_scroll_position(func,uuid,position){
	document.body.scrollTop=position
	obj={'position':position}
	AndroidInterfaceCall(func,uuid,obj)
}
function show_html(func,uuid){
	J('html').css('display','none')
}
function hide_html(func,uuid){
	J('html').css('display','')
}
function show_keyboard(func,uuid){
	AndroidInterfaceCall(func,uuid)
}
function hide_keyboard(func,uuid){
	AndroidInterfaceCall(func,uuid)
}
function save_status(func,uuid){
	obj={'position':document.body.scrollTop}
	AndroidInterfaceCall(func,uuid,obj)
}
function restore_status(func,uuid,obj){
	obj=JSON.parse(obj)
	document.body.scrollTop=obj.
	AndroidInterfaceCall(func,uuid)
}
function finish(func,uuid,save_status){
	obj={save_status:save_status}
	AndroidInterfaceCall(func,uuid,obj)
}
function AndroidInterfaceCall(func,uuid,obj){
	Android.interfaceCall(func,uuid,JSON.stringify(obj))
}

//androidandroidandroidandroidandroid
//androidandroidandroidandroidandroid
//androidandroidandroidandroidandroid
//androidandroidandroidandroidandroid