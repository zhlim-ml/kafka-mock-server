function configuration() {

  karate.configure('logPrettyRequest', true);
  karate.configure('logPrettyResponse', true);
  karate.configure('connectTimeout', 30 * 4000);
  karate.configure('readTimeout', 30 * 4000);
  specialCharater = ".-_+%";

  var config = {
    
  };

  return config;
}