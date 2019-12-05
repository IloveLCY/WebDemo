/**
 * 
 */
var oncheck = function(){
	var checkall = document.getElementById("checkall");
	var checks = document.getElementsByName("check");
	for(var i = 0;i<checks.length;i++){
		checks[i].checked = checkall.checked;
	}
}
function isConfirm(obj){
	
    var flag = confirm('是否真的要删除，删除后无法恢复');
    if(flag){
    	window.open('/WebDemo/empAction_todeleteemp.action?empId='+obj.id);
    }else{
        //alert('取消');
    }

}
var submitQuery = function(curPage){
	if(!isNaN(curPage)){
		document.getElementById('curPage').value = curPage;
	}else{
		document.getElementById('curPage').value = 1;
	}
	
	document.getElementById('queryForm').submit();
}