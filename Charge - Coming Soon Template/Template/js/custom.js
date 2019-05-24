/*
Template Name: Charge - Coming Soon Template
Author: AndrewArts
Version: 1.0
*/

jQuery(function ($) {
	'use strict';

	// ------------[ WINDOW SIZE ]
	var window_width = $(window).width();
	var window_height = $(window).height();

	// ------------[ Preloader animation ]
	function destroyPreloader(){
		$('#preloader').delay(800).fadeOut();
	}
	function liquid(){
		$('.logo_fluid').css({'margin-top':'0px','top':'-36px', 'height':'0px'},1200)
		$('.logo_fluid').delay(300).animate({'height':'60px', 'top':'-25px'},550);
		$('.logo_fluid').animate({'height':'36px', 'top':'0px'},300, function(){
			destroyPreloader();
		});
	}
	liquid();



	// ------------[ BODY SIZE ]
	$('body').width(window_width);
	$('body').height(window_height);

	// ------------[ HOME SETUP ]
	var pagesShowEffect = "slideLeft"; // effect for sections skip
	var startTime = "2016/6/22"; // customizable time (can add hours etc. Check credits to learn about script)

	// YOUTUBE VIDEO BACKGROUND SETTINGS ON LINE 252
	

	// ------------[ BASIC ATTRIBUTIONS ]
	(function(){
		// ------------[ NEW CODES HERE ]
		// do something...

		// ------------[ PAGE:HOME BACKGROUND ]
		if($(".image").length>0)
			$('#home').backstretch('images/wallpapers/slide1.jpg');

		if($(".slider").length>0)
			$('#home').backstretch([
				'images/wallpapers/slide1.jpg',
				'images/wallpapers/slide2.jpg'
			], {duration: 3000, fade: 750});

		// ------------[ PAGES ANIMATION INITIALIZE ]
		if(pagesShowEffect=="undefined") {
			pagesShowEffect = "fade"; // fade, slideLeft, slideRight
			console.log("Page Animation effect undefined. Basic loaded (fade).");
		} else {
			if(pagesShowEffect=="fade" || pagesShowEffect=="slideLeft" || pagesShowEffect=="slideRight"){
				//animation set
			} else {
				pagesShowEffect = "fade";
				console.log("Page Animation effect unknown(used: "+pagesShowEffect+").");
			}
		}

		// ------------[ SUBSCRIBE BUTTON ]
		

		// ------------[ PAGES ARRANGEMENT ]
		$('.page').each(function(){
			if($(this).hasClass('main') || $(this).hasClass('active')) {
				
			} else {
				if(pagesShowEffect=="slideLeft") {
					$(this).css({'left':'-100%'});
					$(this).show();
				} else
				if (pagesShowEffect=="slideRight") {
					$(this).css({'left':'100%'});
					$(this).show();
				} else
				if (pagesShowEffect=="fade" || pagesShowEffect=="undefined") {
					$(this).hide();
				}
			}
		});

		// ------------[ PAGES SIZE (FOR SCROLL) ]
		$('.container').css({'height':(window_height-65)+'px'});

		// ------------[ PARTICLE BACKGROUND SIZE ]
		$('#particle-ground').width(window_width);
		$('#particle-ground').height(window_height);

		// ------------[ MAILCHIMP SUBSCRIBE ]
		$('#mc-form .close').click(function(){
			$('#subscription').fadeOut(350);
			$('#mc-email').val('');
			$('#mc-message').text('');
			
		});
		$('#subscribe_btn').click(function(){
			$('#subscription').fadeIn(350)
		});

	})();
	
	// ------------[ PRELOADER ]
	$(window).load(function() { 
		$('.page').each(function(){
			if($(this).hasClass('main') || $(this).hasClass('active')) {
				
			} else {
				if(pagesShowEffect=="slideLeft") {
					$(this).delay(1200).css({'left':'-100%'});
					$(this).show();
				} else
				if (pagesShowEffect=="slideRight") {
					$(this).delay(1200).css({'left':'100%'});
					$(this).show();
				} else
				if (pagesShowEffect=="fade" || pagesShowEffect=="undefined") {
					$(this).delay(1200).css({'opacity':'0'});
					$(this).hide();
				}
			}
		});
	});

	// ------------[ CONTACT FORM VALIDATION ]
	function cformIsValid() {
		if($("#cf-name").val()==""){
			$("#cf-response").text("Please enter your name.");
			$("#cf-response").removeClass("success");
			$("#cf-response").fadeIn();
			return false;
		} else 
		if($("#cf-email").val()=="") {
			$("#cf-response").text("Please enter your email.");
			$("#cf-response").removeClass("success");
			$("#cf-response").fadeIn();
			return false;
		} else
		if($("#cf-email").val().indexOf("@")<0) {
			$("#cf-response").text("Please enter an valid e-mail address.");
			$("#cf-response").removeClass("success");
			$("#cf-response").fadeIn();
			return false;
		} else
		if($("#cf-message").val()=="") {
			$("#cf-response").text("Please enter a message.");
			$("#cf-response").removeClass("success");
			$("#cf-response").fadeIn();
			return false;
		} else {
			return true;
		}
	}

	// ------------[ CONTACT & SUBSCRIBE FORMS ]
	(function(){
		// ------------[ MAILCHIMP ]
		$('#mc-form').ajaxChimp({
			// mailchimp post url needed
		    url: 'http://hol.us13.list-manage.com/subscribe/post?u=aaaaaaaaaaaaaaaaaaaa&amp;id=LLLLLLLLLLL',
		    callback: callbackSubscribe,
		});

		function callbackSubscribe (resp) {
		    if (resp.result === 'success') {
		    	$("#mc-message").delay(3000).fadeOut();
		    	$("#mc-email").val("");
		    	// do something when subscribe succes ...
		    }
		}

		// ------------[ CONTACT ]
		$("#contact-form").submit(function(event){
			// cancels the form submission
			event.preventDefault();
			if(cformIsValid()){
				$("#cf-response").text("");
				$("#mc-message").fadeOut();
				$("#cf-response").fadeOut();
				submitForm();
			}
		});

		function submitForm(){
			// Initiate Variables With Form Content
			var cfname = $("#cf-name").val();
			var cfemail = $("#cf-email").val();
			var cfmessage = $("#cf-message").val();
	 
			$.ajax({
				type: "POST",
				url: $("#contact-form").attr("action"),
				data: "name=" + cfname + "&email=" + cfemail + "&message="+cfmessage,
				success : function(text){
					formResponse(text);
				}
			});
		}
		function formResponse(response){
			if(response=="success"){
				$("#cf-response").addClass("success");
				$("#cf-response").fadeIn();

				// Success message
				$( "#cf-response" ).text("Your message has been successfully sent!");
				setTimeout(resetCForm, 3000);

			} else {
				$("#cf-response").removeClass("success");
				$("#cf-response").fadeIn();

				// Error message
				$( "#cf-response" ).text("Oops! Something went wrong. Try again!");
			}
			
		}

		function resetCForm(){
			$("#cf-response").fadeOut();
			$("#cf-name").val("");
			$("#cf-email").val("");
			$("#cf-message").val("");
		}
	}());

	// ------------[ PROGRESS BAR ]
	(function () {
		$('.progress').on('inview', function(event, visible, visiblePartX, visiblePartY) {
			if (visible) {
				$.each($('.progress-bar'),function(){
					$(this).css('width', $(this).attr('aria-valuenow')+'%');
					$($(this).attr('alt')).text($(this).attr('aria-valuenow')+'%');
				});
				$(this).off('inview');
			}
		});
	}());

	$(document).ready(function(){
		// ------------[ PARTICLE-GROUND ]
		$("#particle-ground").width(window_width);
		$("#particle-ground").height(window_height);

		if($( "#particle-ground" ).length>0){ // check if PARTICLE-GROUND exists
			$('#particle-ground').particleground({
				dotColor: 'rgba(231, 76, 60, 0.6)',
				lineColor: 'rgba(255, 255, 255, 0.4)',
				particleRadius: 5,
			});
		}

		// ------------[ YOUTUBE BACKGROUND ]
		var videosource = "pXHXlI9yU0w"; /* Code from URL or just URL */
		var startT = "0:4:42"; /* Exactly start time from YT video */
		var stopT = "0:6:34";  /* End time... You know... */

		if($( ".youtube-background" ).length>0){ // check if Youtube bg exists
			if(videosource=='undefined')
				$('home').css({'background-color':'rgba(0,0,0,0.6'});
			if(startT=='undefined') startT='0';
				else {
					var sts = startT.split(':');
					startT = parseInt(sts[0])*3600+parseInt(sts[1])*60+parseInt(sts[2]);
				}
			if(stopT=='undefined') stopT='0';
				else {
					var ets = stopT.split(':');
					stopT = parseInt(ets[0])*3600+parseInt(ets[1])*60+parseInt(ets[2]);
				}

			$(".youtube-background").mb_YTPlayer({
				videoURL:videosource,
				mute:true,
				loop:true,
				showControls:false,
				showAnnotations:false,
				showYTLogo : false,
				gaTrack:false,
				startAt: startT,
				stopAt: stopT,
			});
		}
		// For more customization go to the link: "https://github.com/pupunzi/jquery.mb.YTPlayer/wiki"

		// ------------[ VIDEO BACKGROUND ]
		if($("#video").outerHeight()<window_height){
			$("#video").height(window_height);
			$("#video").width("auto");
		}
		if($("#video").outerHeight()>=window_height && $("#video").outerWidth()<window_width){
			$("#video").width(window_width);
			$("#video").height("auto");
		}
	});

	// ------------[ NAVIGATION SCRIPT ]
	var body_to_show = "none"; // next page to show
	var animShowTime = 550;	   // animation-show time
	var animHideTime = 350;	   // animation-hide time
	var pageLoading = false;   // pause between pages transition

	var navIsMobile = false;   // check if navibar is mobile - active white links (for dark backgrounds)
	if(window_width<=767) navIsMobile = true;
		else navIsMobile = false

	$('.nav-link').each(function(){
		$(this).click(function(){
			if(pageLoading == false) {
				pageLoading = true;
				$(".navbar-collapse").collapse('hide');
				$('.nav-link').removeClass('active');
				$(this).addClass('active');

				body_to_show = $(this).attr('href')

				$('.page').removeClass('active');
				$(body_to_show).addClass('active');

				$('.page').each(function(){
					if(!$(this).hasClass("main")){
						if($(this).hasClass("active")) {
							if(pagesShowEffect=="slideLeft") {
								$(this).animate({'left':'0px'}, animShowTime, function(){
									pageLoading = false;
								});
							} else
							if (pagesShowEffect=="slideRight") {
								$(this).animate({'left':'0px'}, animShowTime, function(){
									pageLoading = false;
								});
							} else
							if (pagesShowEffect=="fade" || pagesShowEffect=="undefined") {
								$(this).css({'opacity' : '1'});
								$(this).show();
							}
						} else {
							if(pagesShowEffect=="slideLeft") {
								$(this).animate({'left':'-100%'}, animHideTime, function(){
									pageLoading = false;
								});
							} else
							if (pagesShowEffect=="slideRight") {
								$(this).animate({'left':'100%'}, animHideTime, function(){
									pageLoading = false;
								});
							} else
							if (pagesShowEffect=="fade" || pagesShowEffect=="undefined") {
								$(this).animate({'opacity' : '0.0'}, animHideTime, function(){
									$(this).hide();
									pageLoading = false;
								});
							}
						}
					};
				});
			}
			return false;
		});
	});

	// ------------[ WINDOW RESIZE UPDATE ]
	$(window).resize(function(){
		window_width = $(window).width();
		window_height = $(window).height();

		// ------------[ BODY SIZE ]
		$('body').width(window_width);
		$('body').height(window_height);

		// ------------[ NAVIGATION ]
		if(window_width<=767) navIsMobile = true;
			else navIsMobile = false

		// ------------[ CONTAINER RESIZE ]
		$('.container').css({'height':(window_height-65)+'px'});

		// ------------[ PARTICLE BACKGROUND RESIZE ]
		$('#particle-ground').width(window_width);
		$('#particle-ground').height(window_height);

		// ------------[ VIDEO BACKGROUND RESIZE ]
		if($("#video").outerHeight()<window_height){
			$("#video").height(window_height);
			$("#video").width("auto");
		}
		if($("#video").outerHeight()>=window_height && $("#video").outerWidth()<window_width){
			$("#video").width(window_width);
			$("#video").height("auto");
		}
	});

	// ------------[ TIME COUNTERS ]
	(function () {
		//--[ counter ]-------------[         get attr         ]------
		$('#countdown').countdown(startTime, function(event) {
		var $this = $(this).html(event.strftime(''
			+ '<li><span class="days color">%D</span><p>days</p></li>'            // DAYS
			+ '<li><span class="hours color">%H</span><p>hours</p></li>' 		  // HOURS
			+ '<li><span class="minutes color">%M</span><p>minutes</p></li>'	  // MINUTES
			+ '<li><span class="seconds color">%S</span><p>seconds</p></li>'));	  // SECONDS
		});
	}());
});