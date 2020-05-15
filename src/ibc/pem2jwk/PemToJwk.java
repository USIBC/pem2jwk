// D. Racine 20200506

package ibc.pem2jwk;

import io.fusionauth.der.*;
import io.fusionauth.jwks.*;
import io.fusionauth.jwks.domain.*;
import io.fusionauth.jwt.*;
import io.fusionauth.jwt.domain.*;
import io.fusionauth.jwt.json.*;
import io.fusionauth.jwt.rsa.*;
import io.fusionauth.pem.*;
import io.fusionauth.pem.domain.*;
import io.fusionauth.security.*;

import java.nio.charset.*;
import java.nio.file.*;
import java.io.*;

public class PemToJwk {

  static String readFile(String path, Charset encoding) throws IOException {
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, encoding); }

  public static void main(String[] args) {
    String pemFile = "";
    if (args.length > 0) {
      pemFile = args[0]; }
    else {
      System.err.println("usage: java -jar PemToJwk.jar pem_file");
      System.exit(1); }
    try {
      String pem = readFile(pemFile, StandardCharsets.US_ASCII);
      JSONWebKey jwk = JSONWebKey.build(pem);
      System.out.println(jwk.toJSON()); }
    catch(IOException e) {
      e.printStackTrace(); }}}
