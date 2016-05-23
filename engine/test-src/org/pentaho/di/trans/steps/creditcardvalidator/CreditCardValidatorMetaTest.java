/*! ******************************************************************************
 *
 * Pentaho Data Integration
 *
 * Copyright (C) 2002-2016 by Pentaho : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/
package org.pentaho.di.trans.steps.creditcardvalidator;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.plugins.PluginRegistry;
import org.pentaho.di.trans.steps.loadsave.LoadSaveTester;
import org.pentaho.di.trans.steps.loadsave.validator.FieldLoadSaveValidator;

public class CreditCardValidatorMetaTest {
  LoadSaveTester loadSaveTester;
  Class<CreditCardValidatorMeta> testMetaClass = CreditCardValidatorMeta.class;

  @Before
  public void setUpLoadSave() throws Exception {
    KettleEnvironment.init();
    PluginRegistry.init( true );
    ArrayList<String> attributes = new ArrayList<String>() {
      {
        add( "dynamicField" );
        add( "cardType" );
        add( "notValidMsg" );
        add( "resultFieldName" );
        add( "onlyDigits" );
      }
    };

    loadSaveTester = new LoadSaveTester( testMetaClass, attributes,
      new HashMap<String, String>(), new HashMap<String, String>(),
      new HashMap<String, FieldLoadSaveValidator<?>>(),  new HashMap<String, FieldLoadSaveValidator<?>>() );
  }

  @Test
  public void testSerialization() throws KettleException {
    loadSaveTester.testSerialization();
  }
}