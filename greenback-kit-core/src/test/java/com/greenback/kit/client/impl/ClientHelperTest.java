/*
 * Copyright 2020 Greenback, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greenback.kit.client.impl;

import java.time.Instant;
import java.time.ZonedDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class ClientHelperTest {
 
    @Test
    public void instantToString() {
        assertThat(ClientHelper.toInstantParameter(Instant.parse("2020-02-01T01:02:03.456Z")), is("2020-02-01T01:02:03.456Z"));
        assertThat(ClientHelper.toInstantParameter(ZonedDateTime.parse("2020-02-01T03:01:09.987-01:00").toInstant()), is("2020-02-01T04:01:09.987Z"));
    }
    
}