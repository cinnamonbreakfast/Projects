var wi = (document.getElementsByClassName("big-card")[0].offsetWidth)/2-30;
var x = document.getElementsByClassName("half");
var i;
for (i = 0; i < x.length; i++) {
	x[i].style.width = wi+"px";
}

var fil = document.getElementsByClassName("fill");
var bar = document.querySelectorAll('.graphic li p')
var val = 0;
for (i = 0; i < fil.length; i++) {
	val = fil[i].getAttribute("value");
	fil[i].style.height = val+"%";
	//if (.childNodes[i].className == "")
	bar[i].textContent  = i+1;
}