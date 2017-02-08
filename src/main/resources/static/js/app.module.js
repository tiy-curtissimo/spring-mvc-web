(function () {
	$(".button-collapse").sideNav();
	$(document).ready(function() {
		Materialize.updateTextFields();
	});	
	angular
		.module('app', [])
		.component('mySillyComponent', {
			template: `¯\\(◉◡◔)/¯`
		});
})();
