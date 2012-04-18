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
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jcouchdb.db.Database;
import org.jcouchdb.document.BaseDocument;

import com.byktol.fredb.modeler.DataRecord;
import com.byktol.fredb.modeler.sql.TableAttribute;
import com.byktol.fredb.modeler.uml.UmlAttribute;
import com.byktol.fredb.modeler.uml.UmlClass;

/**
 * 
 * @author Victor Alvarez
 */
public class CouchDBExporter
  implements DocumentDBExporter
{

  private Database database;

  protected Database connect(
    final String server, final String database)
  {
    return new Database(server, database);
  }

  public void connect1(
    final String server, final String database)
  {
    this.database = connect(
      server,
      database);
  }

  public void setDatabase(
    final Database database)
  {
    this.database = database;
  }

  public void l(
    final DataRecord record, final Map<String, UmlClass> classes)
    throws Exception
  {
    // FIXME: you need to somehow follow the UML models.
    final BaseDocument base = new BaseDocument();

    final String tableName = record.getTable().getName();
    base.setProperty("sql_type", tableName);
    final UmlClass cl = classes.get(tableName);

    for (final Entry<TableAttribute, Object> e : record.getValues().entrySet())
    {
      final String attributeName = e.getKey().getName();
      final String attributeValue = (String) e.getValue();
      final UmlAttribute umlAttribute = cl.getAttributes().get(
        attributeName);

      if (umlAttribute.getType().contains("String"))
      {
        base.setProperty(attributeName, attributeValue);

      } else if (umlAttribute.getType().contains("Number"))
      {
        base.setProperty(attributeName, Double.parseDouble(attributeValue));

      } else if (umlAttribute.getType().contains("Boolean"))
      {
        base.setProperty(attributeName, Boolean.parseBoolean(attributeValue));

      } else
      {
        base.setProperty(attributeName, attributeValue);

      }

    }
    database.createDocument(base);
  }

  public ExportResult l(
    final List<DataRecord> records, final Map<String, UmlClass> classes)
  {
    int i = 0;
    final Map<DataRecord, Exception> bad = new HashMap<DataRecord, Exception>();
    for (final DataRecord dr : records)
    {
      try
      {
        l( dr, classes);
        i++;
      } catch (final Exception e)
      {
        bad.put(dr, e);
      }
    }
    return new ExportResult(i, bad);
  }
}
