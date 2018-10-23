/* Generated By:JavaCC: Do not edit this line. MyParser.java */
  public class MyParser implements MyParserConstants {
    public static void main(String args[]) {
      // a simple comment
      /* a comment /∗ with /∗ several ∗/ nested ∗/ comments */

      MyParser tokeniser;
      if (args.length == 0) {
        System.out.println("Reading from standard input...");
        tokeniser = new MyParser(System.in);
      }
      else if (args.length == 1) {
        try {
          tokeniser = new MyParser(new java.io.FileInputStream(args[0]));
        }
        catch (java.io.FileNotFoundException e) {
          System.err.println("File " + args[0] + " not found.");
          return;
        }
      }
      else {
        System.out.println("MyParser: Usage is one of:");
        System.out.println("      java MyParser < inputfile");
        System.out.println("OR");
        System.out.println("      java MyParser inputfile");
        return;
      }
      try {
                        tokeniser.Program();
                        System.out.println("Parsing successful");
                  }
                catch (ParseException e) {
                        System.out.println("AssignmentOneParser Encountered errors during parse.");
                        System.out.println(e.getMessage());
                }
    }

/* GRAMMAR AND PRODUCTION RULES */
  static final public void Program() throws ParseException {
    DeclList();
    FunctionList();
    Main();
  }

  static final public void DeclList() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VARIABLE:
    case CONSTANT:
      Decl();
      jj_consume_token(SEMICOL);
      DeclList();
      break;
    default:
      jj_la1[0] = jj_gen;

    }
  }

  static final public void Decl() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VARIABLE:
      VarDecl();
      break;
    case CONSTANT:
      ConstDecl();
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void VarDecl() throws ParseException {
    jj_consume_token(VARIABLE);
    jj_consume_token(ID);
    jj_consume_token(COLON);
    Type();
  }

  static final public void ConstDecl() throws ParseException {
    jj_consume_token(CONSTANT);
    jj_consume_token(ID);
    jj_consume_token(COLON);
    Type();
    jj_consume_token(ASSIGN);
    Expression();
  }

  static final public void FunctionList() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER:
    case BOOLEAN:
    case VOID:
      Function();
      FunctionList();
      break;
    default:
      jj_la1[2] = jj_gen;

    }
  }

  static final public void Function() throws ParseException {
    Type();
    jj_consume_token(ID);
    jj_consume_token(L_BRACK);
    ParameterList();
    jj_consume_token(R_BRACK);
    jj_consume_token(IS);
    DeclList();
    jj_consume_token(BEGIN);
    StatementBlock();
    jj_consume_token(RETURN);
    jj_consume_token(L_BRACK);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRUE:
    case FALSE:
    case L_BRACK:
    case MINUS:
    case NUM:
    case ID:
      Expression();
      break;
    default:
      jj_la1[3] = jj_gen;

    }
    jj_consume_token(R_BRACK);
    jj_consume_token(SEMICOL);
    jj_consume_token(END);
  }

  static final public void Type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER:
      jj_consume_token(INTEGER);
      break;
    case BOOLEAN:
      jj_consume_token(BOOLEAN);
      break;
    case VOID:
      jj_consume_token(VOID);
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void ParameterList() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      NempParameterList();
      break;
    default:
      jj_la1[5] = jj_gen;

    }
  }

  static final public void NempParameterList() throws ParseException {
    jj_consume_token(ID);
    jj_consume_token(COLON);
    Type();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COMMA:
      jj_consume_token(COMMA);
      NempParameterList();
      break;
    default:
      jj_la1[6] = jj_gen;

    }
  }

  static final public void Main() throws ParseException {
    jj_consume_token(MAIN);
    jj_consume_token(BEGIN);
    DeclList();
    StatementBlock();
    jj_consume_token(END);
  }

  static final public void StatementBlock() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IF:
    case WHILE:
    case BEGIN:
    case SKIPPY:
    case ID:
      Statement();
      StatementBlock();
      break;
    default:
      jj_la1[7] = jj_gen;

    }
  }

  static final public void Statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ASSIGN:
        jj_consume_token(ASSIGN);
        Expression();
        jj_consume_token(SEMICOL);
        break;
      case L_BRACK:
        jj_consume_token(L_BRACK);
        ArgList();
        jj_consume_token(R_BRACK);
        jj_consume_token(SEMICOL);
        break;
      default:
        jj_la1[8] = jj_gen;

      }
      break;
    case BEGIN:
      jj_consume_token(BEGIN);
      StatementBlock();
      jj_consume_token(END);
      break;
    case IF:
      jj_consume_token(IF);
      Condition();
      jj_consume_token(BEGIN);
      StatementBlock();
      jj_consume_token(END);
      jj_consume_token(ELSE);
      jj_consume_token(BEGIN);
      StatementBlock();
      jj_consume_token(END);
      break;
    case WHILE:
      jj_consume_token(WHILE);
      Condition();
      jj_consume_token(BEGIN);
      StatementBlock();
      jj_consume_token(END);
      break;
    case SKIPPY:
      jj_consume_token(SKIPPY);
      jj_consume_token(SEMICOL);
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Expression() throws ParseException {
    Fragment();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
    case MINUS:
      BinaryArithOp();
      Fragment();
      break;
    default:
      jj_la1[10] = jj_gen;

    }
  }

  static final public void BinaryArithOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      jj_consume_token(PLUS);
      break;
    case MINUS:
      jj_consume_token(MINUS);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Fragment() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case L_BRACK:
        jj_consume_token(L_BRACK);
        ArgList();
        jj_consume_token(R_BRACK);
        FragmentPrime();
        break;
      default:
        jj_la1[12] = jj_gen;
        FragmentPrime();
      }
      break;
    case MINUS:
      jj_consume_token(MINUS);
      jj_consume_token(ID);
      FragmentPrime();
      break;
    case NUM:
      jj_consume_token(NUM);
      FragmentPrime();
      break;
    case TRUE:
      jj_consume_token(TRUE);
      FragmentPrime();
      break;
    case FALSE:
      jj_consume_token(FALSE);
      FragmentPrime();
      break;
    case L_BRACK:
      jj_consume_token(L_BRACK);
      Expression();
      jj_consume_token(R_BRACK);
      FragmentPrime();
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void FragmentPrime() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
    case MINUS:
      BinaryArithOp();
      Fragment();
      FragmentPrime();
      break;
    default:
      jj_la1[14] = jj_gen;

    }
  }

  static final public void Condition() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BITNOT:
      jj_consume_token(BITNOT);
      Condition();
      ConditionPrime();
      break;
    default:
      jj_la1[15] = jj_gen;
      if (jj_2_1(3)) {
        jj_consume_token(L_BRACK);
        Condition();
        jj_consume_token(R_BRACK);
        ConditionPrime();
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case TRUE:
        case FALSE:
        case L_BRACK:
        case MINUS:
        case NUM:
        case ID:
          Expression();
          CompOp();
          Expression();
          ConditionPrime();
          break;
        default:
          jj_la1[16] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
  }

  static final public void ConditionPrime() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BITOR:
      jj_consume_token(BITOR);
      Condition();
      break;
    case BITAND:
      jj_consume_token(BITAND);
      Condition();
      break;
    default:
      jj_la1[17] = jj_gen;

    }
  }

  static final public void CompOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EQUAL:
      jj_consume_token(EQUAL);
      break;
    case N_EQUAL:
      jj_consume_token(N_EQUAL);
      break;
    case L_THAN:
      jj_consume_token(L_THAN);
      break;
    case L_OR_EQU:
      jj_consume_token(L_OR_EQU);
      break;
    case G_THAN:
      jj_consume_token(G_THAN);
      break;
    case G_OR_EQU:
      jj_consume_token(G_OR_EQU);
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void ArgList() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      NempArgList();
      break;
    default:
      jj_la1[19] = jj_gen;

    }
  }

  static final public void NempArgList() throws ParseException {
    jj_consume_token(ID);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COMMA:
      jj_consume_token(COMMA);
      NempArgList();
      break;
    default:
      jj_la1[20] = jj_gen;

    }
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_3R_3() {
    if (jj_3R_4()) return true;
    if (jj_3R_5()) return true;
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_scan_token(L_BRACK)) return true;
    if (jj_3R_1()) return true;
    return false;
  }

  static private boolean jj_3R_2() {
    if (jj_scan_token(BITNOT)) return true;
    if (jj_3R_1()) return true;
    return false;
  }

  static private boolean jj_3R_1() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_2()) {
    jj_scanpos = xsp;
    if (jj_3_1()) {
    jj_scanpos = xsp;
    if (jj_3R_3()) return true;
    }
    }
    return false;
  }

  static private boolean jj_3R_20() {
    return false;
  }

  static private boolean jj_3R_19() {
    if (jj_3R_15()) return true;
    return false;
  }

  static private boolean jj_3R_18() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_19()) {
    jj_scanpos = xsp;
    if (jj_3R_20()) return true;
    }
    return false;
  }

  static private boolean jj_3R_17() {
    if (jj_3R_18()) return true;
    return false;
  }

  static private boolean jj_3R_16() {
    if (jj_scan_token(L_BRACK)) return true;
    return false;
  }

  static private boolean jj_3R_14() {
    if (jj_scan_token(L_BRACK)) return true;
    if (jj_3R_4()) return true;
    return false;
  }

  static private boolean jj_3R_13() {
    if (jj_scan_token(FALSE)) return true;
    if (jj_3R_18()) return true;
    return false;
  }

  static private boolean jj_3R_7() {
    if (jj_3R_15()) return true;
    return false;
  }

  static private boolean jj_3R_12() {
    if (jj_scan_token(TRUE)) return true;
    if (jj_3R_18()) return true;
    return false;
  }

  static private boolean jj_3R_11() {
    if (jj_scan_token(NUM)) return true;
    if (jj_3R_18()) return true;
    return false;
  }

  static private boolean jj_3R_10() {
    if (jj_scan_token(MINUS)) return true;
    if (jj_scan_token(ID)) return true;
    return false;
  }

  static private boolean jj_3R_6() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_9()) {
    jj_scanpos = xsp;
    if (jj_3R_10()) {
    jj_scanpos = xsp;
    if (jj_3R_11()) {
    jj_scanpos = xsp;
    if (jj_3R_12()) {
    jj_scanpos = xsp;
    if (jj_3R_13()) {
    jj_scanpos = xsp;
    if (jj_3R_14()) return true;
    }
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_3R_9() {
    if (jj_scan_token(ID)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_16()) {
    jj_scanpos = xsp;
    if (jj_3R_17()) return true;
    }
    return false;
  }

  static private boolean jj_3R_15() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(33)) {
    jj_scanpos = xsp;
    if (jj_scan_token(34)) return true;
    }
    return false;
  }

  static private boolean jj_3R_4() {
    if (jj_3R_6()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_7()) {
    jj_scanpos = xsp;
    if (jj_3R_8()) return true;
    }
    return false;
  }

  static private boolean jj_3R_8() {
    return false;
  }

  static private boolean jj_3R_5() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(38)) {
    jj_scanpos = xsp;
    if (jj_scan_token(39)) {
    jj_scanpos = xsp;
    if (jj_scan_token(40)) {
    jj_scanpos = xsp;
    if (jj_scan_token(41)) {
    jj_scanpos = xsp;
    if (jj_scan_token(42)) {
    jj_scanpos = xsp;
    if (jj_scan_token(43)) return true;
    }
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public MyParserTokenManager token_source;
  static JavaCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[21];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x1800,0x1800,0x1c000,0x80300000,0x1c000,0x0,0x8000000,0x4c40000,0xc0000000,0x4c40000,0x0,0x0,0x80000000,0x80300000,0x0,0x0,0x80300000,0x0,0x0,0x0,0x8000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0xc004,0x0,0x8000,0x0,0x8000,0x0,0x8000,0x6,0x6,0x0,0xc004,0x6,0x8,0xc004,0x30,0xfc0,0x8000,0x0,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[1];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public MyParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public MyParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new MyParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public MyParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new MyParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public MyParser(MyParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(MyParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        exists = true;
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.add(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[49];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 21; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 49; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

  }
