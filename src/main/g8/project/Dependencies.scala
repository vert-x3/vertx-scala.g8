import sbt._

object Version {
  final val Scala        = "3.5.2"
  final val ScalaTest    = "3.2.19"
  final val Vertx        = "4.5.11"
  final val Logback      = "1.5.12"
  final val ScalaLogging = "3.9.5"
}

object Library {
  val vertx_codegen         = "io.vertx"  % "vertx-codegen"         % Version.Vertx % "provided"
  val vertx_lang_scala      = "io.vertx" %% "vertx-lang-scala"      % Version.Vertx
  val vertx_lang_scala_test = "io.vertx" %% "vertx-lang-scala-test" % Version.Vertx
  val vertx_hazelcast       = "io.vertx"  % "vertx-hazelcast"       % Version.Vertx
  val vertx_web             = "io.vertx"  % "vertx-web"             % Version.Vertx

  val vertx_mqtt                        = "io.vertx" % "vertx-mqtt"                        % Version.Vertx
  val vertx_sql_common                  = "io.vertx" % "vertx-sql-common"                  % Version.Vertx
  val vertx_bridge_common               = "io.vertx" % "vertx-bridge-common"               % Version.Vertx
  val vertx_jdbc_client                 = "io.vertx" % "vertx-jdbc-client"                 % Version.Vertx
  val vertx_mongo_client                = "io.vertx" % "vertx-mongo-client"                % Version.Vertx
  val vertx_mongo_service               = "io.vertx" % "vertx-mongo-service"               % Version.Vertx
  val vertx_auth_common                 = "io.vertx" % "vertx-auth-common"                 % Version.Vertx
  val vertx_auth_shiro                  = "io.vertx" % "vertx-auth-shiro"                  % Version.Vertx
  val vertx_auth_htdigest               = "io.vertx" % "vertx-auth-htdigest"               % Version.Vertx
  val vertx_auth_oauth2                 = "io.vertx" % "vertx-auth-oauth2"                 % Version.Vertx
  val vertx_auth_mongo                  = "io.vertx" % "vertx-auth-mongo"                  % Version.Vertx
  val vertx_auth_jwt                    = "io.vertx" % "vertx-auth-jwt"                    % Version.Vertx
  val vertx_auth_jdbc                   = "io.vertx" % "vertx-auth-jdbc"                   % Version.Vertx
  val vertx_web_common                  = "io.vertx" % "vertx-web-common"                  % Version.Vertx
  val vertx_web_client                  = "io.vertx" % "vertx-web-client"                  % Version.Vertx
  val vertx_sockjs_service_proxy        = "io.vertx" % "vertx-sockjs-service-proxy"        % Version.Vertx
  val vertx_web_templ_freemarker        = "io.vertx" % "vertx-web-templ-freemarker"        % Version.Vertx
  val vertx_web_templ_handlebars        = "io.vertx" % "vertx-web-templ-handlebars"        % Version.Vertx
  val vertx_web_templ_jade              = "io.vertx" % "vertx-web-templ-jade"              % Version.Vertx
  val vertx_web_templ_mvel              = "io.vertx" % "vertx-web-templ-mvel"              % Version.Vertx
  val vertx_web_templ_pebble            = "io.vertx" % "vertx-web-templ-pebble"            % Version.Vertx
  val vertx_web_templ_thymeleaf         = "io.vertx" % "vertx-web-templ-thymeleaf"         % Version.Vertx
  val vertx_mysql_postgresql_client     = "io.vertx" % "vertx-mysql-postgresql-client"     % Version.Vertx
  val vertx_mail_client                 = "io.vertx" % "vertx-mail-client"                 % Version.Vertx
  val vertx_rabbitmq_client             = "io.vertx" % "vertx-rabbitmq-client"             % Version.Vertx
  val vertx_redis_client                = "io.vertx" % "vertx-redis-client"                % Version.Vertx
  val vertx_stomp                       = "io.vertx" % "vertx-stomp"                       % Version.Vertx
  val vertx_tcp_eventbus_bridge         = "io.vertx" % "vertx-tcp-eventbus-bridge"         % Version.Vertx
  val vertx_amqp_bridge                 = "io.vertx" % "vertx-amqp-bridge"                 % Version.Vertx
  val vertx_dropwizard_metrics          = "io.vertx" % "vertx-dropwizard-metrics"          % Version.Vertx
  val vertx_hawkular_metrics            = "io.vertx" % "vertx-hawkular-metrics"            % Version.Vertx
  val vertx_shell                       = "io.vertx" % "vertx-shell"                       % Version.Vertx
  val vertx_kafka_client                = "io.vertx" % "vertx-kafka-client"                % Version.Vertx
  val vertx_circuit_breaker             = "io.vertx" % "vertx-circuit-breaker"             % Version.Vertx
  val vertx_config                      = "io.vertx" % "vertx-config"                      % Version.Vertx
  val vertx_service_discovery           = "io.vertx" % "vertx-service-discovery"           % Version.Vertx
  val vertx_config_git                  = "io.vertx" % "vertx-config-git"                  % Version.Vertx
  val vertx_config_hocon                = "io.vertx" % "vertx-config-hocon"                % Version.Vertx
  val vertx_config_kubernetes_configmap = "io.vertx" % "vertx-config-kubernetes-configmap" % Version.Vertx
  val vertx_config_redis                = "io.vertx" % "vertx-config-redis"                % Version.Vertx
  val vertx_config_spring_config_server = "io.vertx" % "vertx-config-spring-config-server" % Version.Vertx
  val vertx_config_yaml                 = "io.vertx" % "vertx-config-yaml"                 % Version.Vertx
  val vertx_config_zookeeper            = "io.vertx" % "vertx-config-zookeeper"            % Version.Vertx

  // non-vert.x deps
  val scalaTest     = "org.scalatest"              %% "scalatest"       % Version.ScalaTest
  val logback       = "ch.qos.logback"              % "logback-classic" % Version.Logback
  val scala_logging = "com.typesafe.scala-logging" %% "scala-logging"   % Version.ScalaLogging
}
