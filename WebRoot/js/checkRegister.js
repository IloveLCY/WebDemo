var checkName = function(){
	var userName = document.getElementById("userName");
	var userNameMsg = document.getElementById("userNameMsg");
	 if(userName.value==null || userName.value.length==0){
         userNameMsg.innerHTML = '<span style="color:#f00;">用户名不可以为空</span>';
         return false;
     }
	 if(userName.value.length<6|| userName.value.length>20){
         userNameMsg.innerHTML = '<span style="color:#f00;">用户名长度必须6-20</span>';
         return false;
	 }
	 userNameMsg.innerHTML = '<span style="color:#0f0;">√</span>';
     return true;
}
var checkPsd = function(){
	var password = document.getElementById("password");
	var userPsdMsg = document.getElementById("userPsdMsg");
	if(password.value==null||password.value.lenght==0){
		userPsdMsg.innerHTML = '<span style="color:#f00;">密码不可以为空</span>';
	}
	if(password.value.length<6|| password.value.length>20){
		userPsdMsg.innerHTML = '<span style="color:#f00;">密码长度必须6-20</span>';
        return false;
	 }
	userPsdMsg.innerHTML = '<span style="color:#0f0;">√</span>';
    return true;
}
var checkForm = function () {
    if(checkName() && checkPsd()){  // 截断流
        return true;
    }
    return false;
}