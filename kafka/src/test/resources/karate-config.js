function configuration() {

  karate.configure('logPrettyResponse', false);
  karate.configure('connectTimeout', 30 * 4000);
  karate.configure('readTimeout', 30 * 4000);
  specialCharater = ".-_+%";

  var config = {
  };

  return config;
}