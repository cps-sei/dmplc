/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>For All Function Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getForAllFunctionEnum()
 * @model
 * @generated
 */
public enum ForAllFunctionEnum implements Enumerator
{
  /**
   * The '<em><b>Forall node</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FORALL_NODE_VALUE
   * @generated
   * @ordered
   */
  FORALL_NODE(0, "forall_node", "forall_node"),

  /**
   * The '<em><b>Forall other</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FORALL_OTHER_VALUE
   * @generated
   * @ordered
   */
  FORALL_OTHER(1, "forall_other", "forall_other"),

  /**
   * The '<em><b>Forall other lower</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FORALL_OTHER_LOWER_VALUE
   * @generated
   * @ordered
   */
  FORALL_OTHER_LOWER(2, "forall_other_lower", "forall_other_lower"),

  /**
   * The '<em><b>Forall other higher</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FORALL_OTHER_HIGHER_VALUE
   * @generated
   * @ordered
   */
  FORALL_OTHER_HIGHER(3, "forall_other_higher", "forall_other_higher");

  /**
   * The '<em><b>Forall node</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Forall node</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FORALL_NODE
   * @model name="forall_node"
   * @generated
   * @ordered
   */
  public static final int FORALL_NODE_VALUE = 0;

  /**
   * The '<em><b>Forall other</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Forall other</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FORALL_OTHER
   * @model name="forall_other"
   * @generated
   * @ordered
   */
  public static final int FORALL_OTHER_VALUE = 1;

  /**
   * The '<em><b>Forall other lower</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Forall other lower</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FORALL_OTHER_LOWER
   * @model name="forall_other_lower"
   * @generated
   * @ordered
   */
  public static final int FORALL_OTHER_LOWER_VALUE = 2;

  /**
   * The '<em><b>Forall other higher</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Forall other higher</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FORALL_OTHER_HIGHER
   * @model name="forall_other_higher"
   * @generated
   * @ordered
   */
  public static final int FORALL_OTHER_HIGHER_VALUE = 3;

  /**
   * An array of all the '<em><b>For All Function Enum</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ForAllFunctionEnum[] VALUES_ARRAY =
    new ForAllFunctionEnum[]
    {
      FORALL_NODE,
      FORALL_OTHER,
      FORALL_OTHER_LOWER,
      FORALL_OTHER_HIGHER,
    };

  /**
   * A public read-only list of all the '<em><b>For All Function Enum</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ForAllFunctionEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>For All Function Enum</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ForAllFunctionEnum get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ForAllFunctionEnum result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>For All Function Enum</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ForAllFunctionEnum getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ForAllFunctionEnum result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>For All Function Enum</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ForAllFunctionEnum get(int value)
  {
    switch (value)
    {
      case FORALL_NODE_VALUE: return FORALL_NODE;
      case FORALL_OTHER_VALUE: return FORALL_OTHER;
      case FORALL_OTHER_LOWER_VALUE: return FORALL_OTHER_LOWER;
      case FORALL_OTHER_HIGHER_VALUE: return FORALL_OTHER_HIGHER;
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
  private ForAllFunctionEnum(int value, String name, String literal)
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
  
} //ForAllFunctionEnum
