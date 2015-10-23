$('document').ready(function(){

	$.get('http://localhost:3000/pessoas').done(function(data){

		data.forEach(function(elem){

			$('h2').append(

				$('<h4>')

			);

		});

	});

});

