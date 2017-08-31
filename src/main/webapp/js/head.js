var ctx = function() {
	var p = window.location.pathname;
	var index = p.substr(1).indexOf("/");
	return p.substr(0, index + 1);
}();
