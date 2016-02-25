/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Built In Function Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getBuiltInFunctionEnum()
 * @model
 * @generated
 */
public enum BuiltInFunctionEnum implements Enumerator
{
  /**
   * The '<em><b>Exists other</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EXISTS_OTHER_VALUE
   * @generated
   * @ordered
   */
  EXISTS_OTHER(0, "exists_other", "exists_other"),

  /**
   * The '<em><b>Exists higher</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EXISTS_HIGHER_VALUE
   * @generated
   * @ordered
   */
  EXISTS_HIGHER(1, "exists_higher", "exists_higher"),

  /**
   * The '<em><b>Exists lower</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EXISTS_LOWER_VALUE
   * @generated
   * @ordered
   */
  EXISTS_LOWER(2, "exists_lower", "exists_lower");

  /**
   * The '<em><b>Exists other</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Exists other</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EXISTS_OTHER
   * @model name="exists_other"
   * @generated
   * @ordered
   */
  public static final int EXISTS_OTHER_VALUE = 0;

  /**
   * The '<em><b>Exists higher</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Exists higher</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EXISTS_HIGHER
   * @model name="exists_higher"
   * @generated
   * @ordered
   */
  public static final int EXISTS_HIGHER_VALUE = 1;

  /**
   * The '<em><b>Exists lower</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Exists lower</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EXISTS_LOWER
   * @model name="exists_lower"
   * @generated
   * @ordered
   */
  public static final int EXISTS_LOWER_VALUE = 2;

  /**
   * An array of all the '<em><b>Built In Function Enum</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final BuiltInFunctionEnum[] VALUES_ARRAY =
    new BuiltInFunctionEnum[]
    {
      EXISTS_OTHER,
      EXISTS_HIGHER,
      EXISTS_LOWER,
    };

  /**
   * A public read-only list of all the '<em><b>Built In Function Enum</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<BuiltInFunctionEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Built In Function Enum</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static BuiltInFunctionEnum get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      BuiltInFunctionEnum result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Built In Function Enum</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static BuiltInFunctionEnum getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      BuiltInFunctionEnum result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Built In Function Enum</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static BuiltInFunctionEnum get(int value)
  {
    switch (value)
    {
      case EXISTS_OTHER_VALUE: return EXISTS_OTHER;
      case EXISTS_HIGHER_VALUE: return EXISTS_HIGHER;
      case EXISTS_LOWER_VALUE: return EXISTS_LOWER;
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
  private BuiltInFunctionEnum(int value, String name, String literal)
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
  
} //BuiltInFunctionEnum
