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

import java.util.HashMap;
import java.util.Map.Entry;

import org.jcouchdb.db.Database;
import org.jcouchdb.document.BaseDocument;
import org.junit.Test;

import com.byktol.fredb.modeler.DataRecord;
import com.byktol.fredb.modeler.sql.Table;
import com.byktol.fredb.modeler.sql.TableAttribute;

/**
 * 
 * @author Victor Alvarez
 */
public class CouchDBConnection
{

  @Test
  public void testConnection()
  {
//    Database database = new Database("localhost", "");
//
//    BaseDocument base = new BaseDocument();
//    DataRecord record = new DataRecord();
//
//    TableAttribute at = new TableAttribute();
//    at.setName("id");
//
//    HashMap<TableAttribute, Object> values = new HashMap<TableAttribute, Object>(1);
//    values.put(at, "0");
//
//    at = new TableAttribute();
//    at.setName("name");
//    values.put(at, "'hello world'");
//
//    Table table = new Table();
//    table.setName("corns");
//
//    record.setTable(table);
//    record.setValues(values);
//    base.setProperty("sql_type", record.getTable().getName());
//
//    for(Entry<TableAttribute, Object> e : record.getValues().entrySet())
//    {
//      base.setProperty(e.getKey().getName(), e.getValue());
//    }
//    database.createDocument(base);
  }
}
