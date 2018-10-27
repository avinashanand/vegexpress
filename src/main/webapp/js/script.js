$(function(){
	console.log('initialized');
	
	
	$.ajax({
		url: '/list',
	}).done(function(data){
		$.each(data, function(index, item){
			console.log('name:' + item.name);
			var el = $('<div class="wrap-item nitu"> </div>');
			el.append('<h2 id="'+ item.id + '">' + item.name.toUpperCase() + '</h2>');
			el.append('<p><img src="' + item.img + '"></p>');
			el.append('<p class="price"><strong> ₹'+ item.price + '/ ' + item.unit + '<strong></p>');
			if(item.unit === 'KG'){
				el.append('<p class="qty"><select><option>250GM</option>500GM<option>1KG</option><option>2KG</option>  </select></p>');
			}
			if(item.unit === 'PIECE'){
				el.append('<p class="qty"><select><option>1 BOX</option>2 BOX<option>3 BOX</option><option>4 BOX</option>  </select></p>');
			}
			
			el.append('<p><a class="btn btn-primary" role="button">Add to Cart</a></p>');
			var el1 = $('<div class="col-lg-4"></div>');
			el1.append(el);
			$('#mainContainer').append(el1);
			
		});
	});
	
	$.ajax({
		url: '/status',
	}).done(function(data){
		
		if(data === 'loggedin'){
			$('#user').append('<a href="/logout">Logout</a>');
		}
		else{
			$('#user').append('<!-- Button trigger modal -->\r\n<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#loginservice\">\r\n Login or Signup \r\n<\/button>\r\n<!-- Modal -->\r\n<div class=\"modal fade\" id=\"loginservice\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"loginserviceLabel\" aria-hidden=\"true\">\r\n   <div class=\"modal-dialog\" role=\"document\">\r\n      <div class=\"modal-content\">\r\n         <div class=\"modal-header\">\r\n            <h5 class=\"modal-title\" id=\"loginserviceLabel\">Log In<\/h5>\r\n            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n            <span aria-hidden=\"true\">&times;<\/span>\r\n            <\/button>\r\n         <\/div>\r\n         <div class=\"modal-body\">\r\n            <form>\r\n               <div class=\"form-group\">\r\n                  <label for=\"exampleInputEmail1\">Email address<\/label>\r\n                  <input type=\"email\" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" placeholder=\"Enter email\">\r\n                  <small id=\"emailHelp\" class=\"form-text text-muted\">We\'ll never share your email with anyone else.<\/small>\r\n               <\/div>\r\n               <div class=\"form-group\">\r\n                  <label for=\"exampleInputPassword1\">Password<\/label>\r\n                  <input type=\"password\" class=\"form-control\" id=\"exampleInputPassword1\" placeholder=\"Password\">\r\n               <\/div>\r\n            <\/form>\r\n         <\/div>\r\n         <div class=\"modal-footer\">\r\n            <button type=\"button\" class=\"btn btn-primary\">Login<\/button>\r\n            <div>\r\n               <span><a href=\"\/register\">Register<\/a><\/span>\r\n               <span><a href=\"\/forgot\">Forgot Password<\/a><\/span>\r\n            <\/div>\r\n         <\/div>\r\n      <\/div>\r\n   <\/div>\r\n<\/div>');
		}			
	
	});
})