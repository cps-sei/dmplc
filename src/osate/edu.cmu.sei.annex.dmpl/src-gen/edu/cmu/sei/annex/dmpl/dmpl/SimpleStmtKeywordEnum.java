/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Simple Stmt Keyword Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getSimpleStmtKeywordEnum()
 * @model
 * @generated
 */
public enum SimpleStmtKeywordEnum implements Enumerator
{
  /**
   * The '<em><b>Break</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BREAK_VALUE
   * @generated
   * @ordered
   */
  BREAK(0, "break", "break"),

  /**
   * The '<em><b>Continue</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CONTINUE_VALUE
   * @generated
   * @ordered
   */
  CONTINUE(1, "continue", "continue"),

  /**
   * The '<em><b>Return</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RETURN_VALUE
   * @generated
   * @ordered
   */
  RETURN(2, "return", "return");

  /**
   * The '<em><b>Break</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Break</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BREAK
   * @model name="break"
   * @generated
   * @ordered
   */
  public static final int BREAK_VALUE = 0;

  /**
   * The '<em><b>Continue</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Continue</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CONTINUE
   * @model name="continue"
   * @generated
   * @ordered
   */
  public static final int CONTINUE_VALUE = 1;

  /**
   * The '<em><b>Return</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Return</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RETURN
   * @model name="return"
   * @generated
   * @ordered
   */
  public static final int RETURN_VALUE = 2;

  /**
   * An array of all the '<em><b>Simple Stmt Keyword Enum</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final SimpleStmtKeywordEnum[] VALUES_ARRAY =
    new SimpleStmtKeywordEnum[]
    {
      BREAK,
      CONTINUE,
      RETURN,
    };

  /**
   * A public read-only list of all the '<em><b>Simple Stmt Keyword Enum</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<SimpleStmtKeywordEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Simple Stmt Keyword Enum</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static SimpleStmtKeywordEnum get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      SimpleStmtKeywordEnum result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Simple Stmt Keyword Enum</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static SimpleStmtKeywordEnum getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      SimpleStmtKeywordEnum result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Simple Stmt Keyword Enum</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static SimpleStmtKeywordEnum get(int value)
  {
    switch (value)
    {
      case BREAK_VALUE: return BREAK;
      case CONTINUE_VALUE: return CONTINUE;
      case RETURN_VALUE: return RETURN;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private SimpleStmtKeywordEnum(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //SimpleStmtKeywordEnum
