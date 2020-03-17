function initMaterial(){
	$('.chips').material_chip({ placeholder: 'Enter a tag', secondaryPlaceholder: '+Tag', });
	$(".modal").modal();
	$('select').material_select();
	$("ul.tabs").tabs();
	$('.collapsible').collapsible();
	$(".dropdown-button").dropdown();
	Materialize.updateTextFields();
}
