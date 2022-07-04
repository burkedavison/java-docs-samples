/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// [START cloudrun_helloworld_service]
// [START run_helloworld_service]

package com.example.helloworld;

import java.util.HashMap;
import java.util.StringBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloworldApplication {

  final String logoBW = 
  "                                                                                \n"+
  "                                                                                \n"+
  "                              rrrrrrrrrrrrrrrrrrrr                              \n"+
  "                         rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr                        \n"+
  "                      rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr                     \n"+
  "                    rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrbb                   \n"+
  "                  rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrbbbbbb                 \n"+
  "                rrrrrrrrrrrrrrrrrrrrr       rrrrrrrrrrrrbbbbbbbbb               \n"+
  "              rrrrrrrrrrrrrrrrrrr             rrrrrrrbbbbbbbbbbbbb              \n"+
  "             rrrrrrrrrrrrrrrr                      bbbbbbbbbbbbbbbb             \n"+
  "            rrrYYYYYYYYYYYYYYYY                      bbbbbbbbbbbbbbb            \n"+
  "           YYYYYYYYYYYYYYYYYYYYYYY                     bbbbbbbbbbbbbb           \n"+
  "         YYYYYYYYYYYYYYYYYYYYYYYYYYY                    bbbbbbbbbbbbbb          \n"+
  "       YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY                  bbbbbbbbbbbbbbbb        \n"+
  "     YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY                  bbbbbbbbbbbbbbbbb      \n"+
  "    YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY                    bbbbbbbbbbbbbbbbbb     \n"+
  "   YYYYYYYYYYYYYYYYY        YYYYYYY                          bbbbbbbbbbbbbbb    \n"+
  "  YYYYYYYYYYYYYYY              YY                               bbbbbbbbbbbbb   \n"+
  "  YYYYYYYYYYYYYY                                                 bbbbbbbbbbbbb  \n"+
  "  YYYYYYYYYYYYY                                                  bbbbbbbbbbbbb  \n"+
  "  YYYYYYYYYYYYY                                                  bbbbbbbbbbbbb  \n"+
  "  YYYYYYYYYYYYYY                                                 bbbbbbbbbbbbb  \n"+
  "   YYYYYYYYYYYYYYY                                             bbbbbbbbbbbbbb   \n"+
  "    YYYYYYYYYYYYYYY                                          bbbbbbbbbbbbbbb    \n"+
  "     YYYYYYYYYYYYYGGGGGGGGGGGGGGGGGGGGGGGbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb     \n"+
  "      YYYYYYYYYYGGGGGGGGGGGGGGGGGGGGGGGGGbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb      \n"+
  "        YYYYYYGGGGGGGGGGGGGGGGGGGGGGGGGGGbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb        \n"+
  "          YYGGGGGGGGGGGGGGGGGGGGGGGGGGGGGbbbbbbbbbbbbbbbbbbbbbbbbbbbbb          \n"+
  "              GGGGGGGGGGGGGGGGGGGGGGGGGGGbbbbbbbbbbbbbbbbbbbbbbbbbb             \n"+
  "                 GGGGGGGGGGGGGGGGGGGGGGGGbbbbbbbbbbbbbbbbbbbbbbb                \n"+
  "                                                                                \n"+
  "                                                                                \n";

  @RestController
  class HelloworldController {
    @GetMapping("/")
    String hello() {
      return colorize(logoBW);
    }
  }

  public static void main(String[] args) {
    SpringApplication.run(HelloworldApplication.class, args);
  }

	public final static String colorize(final String ascii, final String mode) {
    
		StringBuilder returnString = new StringBuilder();

		final HashMap<Character, String> colorGlyphs = new HashMap<>();

    colorGlyphs.put('r', "🔴");
    colorGlyphs.put('G', "💚️");
    colorGlyphs.put('Y', "💛️");
    colorGlyphs.put('b', "💙️");
    colorGlyphs.put(' ', "⚪️️");

		for (Character c : ascii.toCharArray()) {
			returnString.append(colorGlyphs.getOrDefault(c, c.toString()));
		}

		return returnString.toString();
	}
}
// [END run_helloworld_service]
// [END cloudrun_helloworld_service]
