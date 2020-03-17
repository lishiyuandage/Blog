function editorSimpleInit(){
	return new SimpleMDE({
		        element: document.getElementById("mdeditor"),
		        autoDownloadFontAwesome: false,
				hideIcons: ["guide"],
				toolbar: simple,
				placeholder: "我不推荐你评论 博主666 ，垃圾博客、谢谢、很好等毫无意义的评论，,支持markdown语法",
				renderingConfig: {
					singleLineBreaks: true,
					codeSyntaxHighlighting: true,
				},
				status:false
		    });
}
function editorFullInit(){
	return new SimpleMDE({
				autoDownloadFontAwesome: false,
		        element: document.getElementById("mdeditor"),
		        autofocus: true,
				hideIcons: ["guide"],
				toolbar: full,
				placeholder: "支持markdown语法",
				renderingConfig: {
					singleLineBreaks: true,
					codeSyntaxHighlighting: true,
				},
				status:false
		    });
}
