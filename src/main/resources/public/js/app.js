
$().ready( function() {
  console.log("js initalisation...")
  var notifications = '/notifications';
  var socket = new SockJS(notifications);
  var client = Stomp.over(socket);
  client.connect(
    {},
    function (frame) {
      console.log("connected " + frame);
      var username = frame.headers['user-name'];
      
      client.subscribe("/topic/alarms", function(message) {
        console.log("Alarm triggerd. " + message);
      });

      client.subscribe("/topic/formSubmitEvents", function(message) {
        console.log("FormSubmitEvents triggerd. " + message);
      });

    }
  )
});