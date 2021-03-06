/**
 * Copyright 2007 The Apache Software Foundation
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hbase.mapred;

import java.io.IOException;

import org.apache.hadoop.hbase.HStoreKey;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;


/**
 * Pass the given key and record as-is to reduce
 */
public class IdentityTableMap extends TableMap<Text, MapWritable> {

  /** constructor */
  public IdentityTableMap() {
    super();
  }

  /**
   * Pass the key, value to reduce
   *
   * @see org.apache.hadoop.hbase.mapred.TableMap#map(org.apache.hadoop.hbase.HStoreKey, org.apache.hadoop.io.MapWritable, org.apache.hadoop.mapred.OutputCollector, org.apache.hadoop.mapred.Reporter)
   */
  @Override
  public void map(HStoreKey key, MapWritable value,
      OutputCollector<Text,MapWritable> output,
      @SuppressWarnings("unused") Reporter reporter) throws IOException {
    
    Text tKey = key.getRow();
    output.collect(tKey, value);
  }
}
