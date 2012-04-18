/*
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
package com.byktol.fredb.exporter;

import java.util.Map;

import com.byktol.fredb.modeler.DataRecord;

/**
 * @author Victor Alvarez
 */
public class ExportResult {
  Map<DataRecord, Exception> bad;
  int good = 0;
  
  public ExportResult(int good, Map<DataRecord, Exception> bad) {
    this.good = good;
    this.bad = bad;
  }

  public Map<DataRecord, Exception> getBad() {
    return bad;
  }

  public int getGood() {
    return good;
  }
}
