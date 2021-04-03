<html>
<?php

$curl = curl_init();

curl_setopt_array($curl, array(
  CURLOPT_URL => "https://fcm.googleapis.com/fcm/send",
  CURLOPT_RETURNTRANSFER => true,
  CURLOPT_ENCODING => "",
  CURLOPT_MAXREDIRS => 10,
  CURLOPT_TIMEOUT => 30,
  CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  CURLOPT_CUSTOMREQUEST => "POST",
  CURLOPT_POSTFIELDS => "{\r\n  \"to\": \"/topics/shop2\", \r\n   \"data\": {\r\n     \"title\"  : \" This is my title message \",\r\n     \"body\" : \" This is the body of my message \"\r\n   }\r\n}",
  CURLOPT_HTTPHEADER => array(
    "authorization: key=AAAAqqNTRTA:APA91bHsL1bWPLLNxEhLiIjD8A2qiZokBqott0L_K4f3x33ULyPE6e8mUsGyGivWYqgXD_HGia4DjEp0lxuzrqTLBm0a5YfBbVVj_WJu7oUdoCWCjJBpqE30b13gK3qijhGdvFhReHqB",
    "cache-control: no-cache",
    "content-type: application/json"
  ),
));

$response = curl_exec($curl);
$err = curl_error($curl);

curl_close($curl);

if ($err) {
  echo "cURL Error #:" . $err;
 
} else {
  echo $response;
 
  
}
?>
