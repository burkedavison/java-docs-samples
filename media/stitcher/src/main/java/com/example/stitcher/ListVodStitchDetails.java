/*
 * Copyright 2022 Google LLC
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

package com.example.stitcher;

// [START video_stitcher_list_vod_stitch_details]

import com.google.cloud.video.stitcher.v1.ListVodStitchDetailsRequest;
import com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient;
import com.google.cloud.video.stitcher.v1.VodSessionName;
import com.google.cloud.video.stitcher.v1.VodStitchDetail;
import java.io.IOException;

public class ListVodStitchDetails {

  public static void main(String[] args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String location = "us-central1";
    String sessionId = "my-session-id";

    listVodStitchDetails(projectId, location, sessionId);
  }

  public static void listVodStitchDetails(String projectId, String location, String sessionId)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (VideoStitcherServiceClient videoStitcherServiceClient =
        VideoStitcherServiceClient.create()) {
      ListVodStitchDetailsRequest listVodStitchDetailsRequest =
          ListVodStitchDetailsRequest.newBuilder()
              .setParent(VodSessionName.of(projectId, location, sessionId).toString())
              .build();

      VideoStitcherServiceClient.ListVodStitchDetailsPagedResponse response =
          videoStitcherServiceClient.listVodStitchDetails(listVodStitchDetailsRequest);
      System.out.println("VOD stitch details:");

      for (VodStitchDetail stitchDetail : response.iterateAll()) {
        System.out.println(stitchDetail.toString());
      }
    }
  }
}
// [END video_stitcher_list_vod_stitch_details]
