(function () {
	$(".button-collapse").sideNav();
	$(document).ready(function() {
		Materialize.updateTextFields();
	});	
	$(document).ready(function() {
		$('select').material_select();
	});
	angular
		.module('app', [])
		.component('mySillyComponent', {
			template: `¯\\(◉◡◔)/¯`
		});
})();
