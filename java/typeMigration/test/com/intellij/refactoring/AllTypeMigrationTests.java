/*
 * User: anna
 * Date: 04-Aug-2008
 */
package com.intellij.refactoring;

import com.intellij.codeInsight.ConvertToAtomicIntentionTest;
import com.intellij.codeInsight.ConvertToThreadLocalIntentionTest;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTypeMigrationTests {
   @SuppressWarnings({"UnusedDeclaration"})
  public static Test suite() {
     final TestSuite suite = new TestSuite();
     suite.addTestSuite(TypeMigrationTest.class);
     suite.addTestSuite(TypeMigrationByAtomicRuleTest.class);
     suite.addTestSuite(TypeMigrationByThreadLocalRuleTest.class);
     suite.addTestSuite(MigrateTypeSignatureTest.class);
     suite.addTestSuite(ChangeTypeSignatureTest.class);
     suite.addTestSuite(WildcardTypeMigrationTest.class);
     suite.addTestSuite(ConvertToAtomicIntentionTest.class);
     suite.addTestSuite(ConvertToThreadLocalIntentionTest.class);
     return suite;
   }
}