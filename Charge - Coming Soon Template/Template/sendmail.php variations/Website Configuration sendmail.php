<?php
	// Define root of mailer - DON'T EDIT
	require_once('mailer/class.phpmailer.php');

	// Website user information
	$name = $_POST['name'];			// User name
	$sender= $_POST['email'];		// User E-mail
	$message = $_POST['message'];	// Message sent TO YOU by User

	// Initialization
	$mail = new PHPMailer();

	// Set timezone for you
	date_default_timezone_set("Europe/Bucharest"); // IMPORTANT

	// Message (compatible with E-mail templates)
	// Only sent to you. Nothing sent to USER.
	$body = "Charge contact form<br>From: ".$name."<br>E-Mail: ".$sender."<br>Message: <i>".$message."</i> <br><br><br><b>Send on ".date("l").",".date("m/d/Y")." at ".date("h:i:sa")."</b>";

	//$mail->IsSMTP(); // telling the class to use SMTP
	$mail->Host	   = "mail.domain.com"; // SMTP server
	$mail->SMTPDebug  = 1;				// enables SMTP debug information (for testing)
											// 1 = errors and messages
											// 2 = messages only
	$mail->SMTPAuth   = true;			// enable SMTP authentication
	$mail->SMTPSecure = "tls";			// sets the prefix to the servier
	$mail->Host	   = "mail.domain.com";	// sets SMTP server
	$mail->Port	   = 587;				// set the SMTP port (this is GMAIL port)
	$mail->Username   = "contact@domain.com";  // username
	$mail->Password   = "YOURPASSWORD";		// password

	$mail->SetFrom('contact@domain.com', 'DOMAIN'); // Sent from who - you can add user, 

	$mail->AddReplyTo("contact@domain.com","DOMAIN"); // To who to reply

	$mail->Subject	= "Charge theme - contact form";  // Subjeect :)

	$mail->AltBody	= "To view the message, please use an HTML compatible email viewer!"; // optional, comment out and test

	$mail->MsgHTML($body); // Apply body to mail (read a few lines up)

	$mail->AddAddress("contact@domain.com", "COMPANY"); // At this point, you're sending the message from your website to your E-mail. As others tought NOT TO YOUR WEBSITE USER. So, a few configurations up here doesn't really matter, like hm SetFrom or AddReplyTo. There are just in case you want to inform your user, via E-mail, method which is hated by a lot, that his (or her) message was sent to you and succesfully stored in your Inbox (and soon sent to Trash by you, hehe).

	// This condition communicates with js Ajax. Don't modify
	if(!$mail->Send()) {
	  echo "error";
	} else {
	  echo "success";
	}
?>