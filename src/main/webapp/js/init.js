var simple=["undo","redo","|","bold",  "heading", "horizontal-rule","|", "quote",{
			name: "link",
			action: addLink,
			className: "fa fa-link",
			title: "link",
		},"|","preview"];
var full=["undo","redo","|","bold","italic","strikethrough","heading","horizontal-rule","code","quote","unordered-list","ordered-list","clean-block","link",{
			name: "image",
			action: imageUpload,
			className: "fa fa-picture-o",
			title: "Insert Image",
		},"table","|","preview","side-by-side","fullscreen"];

function imageUpload(){
	$("#imageUpload").modal("open");
}
function addLink(){
	$("#addLink").modal("open");
}

function uploadFile(){
	var file=document.getElementById("file");
	var filemaxsize = 1024 * 3;//3M 
    var Size = file.files[0].size / 1024; 
    var upfile=file.files[0];
     if(Size > filemaxsize) { 
    	 Materialize.toast("图片不能大于3mb",2000,"rounded red lighten-2");
         return; 
     } 
     if(!file.files[0].type.match(/image.*/)) { 
    	 Materialize.toast("请选择正确格式的图片！！！",2000,"rounded red lighten-2");
    	 return;
     }
     var formdata=new FormData();
     formdata.append("file",upfile);
     $.post({
    	 url:"file/upload",
    	 processData:false,
   		contentType: false,
    	 data:formdata,
    	 success:function(data){
    		 simplemde.codemirror.replaceSelection("![图片]("+data+")");
    	 }
     });
}
function insertLink(){
	var link=$("#link").val();
	var linkName=$("#link_name").val();
	simplemde.codemirror.replaceSelection("["+link+"](http://"+linkName+")");
}

