annotation class a
interface A
interface B

<!FUNCTION_DECLARATION_WITH_NO_NAME, CONFLICTING_OVERLOADS!>fun ()<!> {}
<!FUNCTION_DECLARATION_WITH_NO_NAME, CONFLICTING_OVERLOADS!>fun A.()<!> {}

<!FUNCTION_DECLARATION_WITH_NO_NAME, CONFLICTING_OVERLOADS!>a fun ()<!> {}
<!FUNCTION_DECLARATION_WITH_NO_NAME, CONFLICTING_OVERLOADS!>fun @a A.()<!> {}

class Outer {
    <!FUNCTION_DECLARATION_WITH_NO_NAME, CONFLICTING_OVERLOADS!>fun ()<!> {}
    <!FUNCTION_DECLARATION_WITH_NO_NAME!>fun B.()<!> {}

    <!FUNCTION_DECLARATION_WITH_NO_NAME, CONFLICTING_OVERLOADS!>a fun ()<!> {}
    <!FUNCTION_DECLARATION_WITH_NO_NAME!>fun @a A.()<!> {}
}

fun outerFun() {
    <!FUNCTION_DECLARATION_WITH_NO_NAME!>fun ()<!> {}
    <!FUNCTION_DECLARATION_WITH_NO_NAME!>fun B.()<!> {}

    <!FUNCTION_DECLARATION_WITH_NO_NAME!>@a fun ()<!> {}
    <!FUNCTION_DECLARATION_WITH_NO_NAME!>fun @a A.()<!> {}
}