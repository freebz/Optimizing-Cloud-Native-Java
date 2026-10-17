public EvalValue execMethod(final byte[] instr) {
    if (instr == null || instr.length == 0)
        return null;
    
    EvaluationStack eval = new EvaluationStack();

    int current = 0;
    LOOP:
    while (true) {
        byte b = instr[current++];
        Opcode op = table[b & 0xff];
        if (op == null) {
            System.err.println("Unrecognized opcode byte: " + (b & 0xff));
            System.exit(1);
        }
        byte num = op.numParams();
        switch (op) {
            case IADD:
                eval.iadd();
                break;
            case ICONST_0:
                eval.iconst(0);
                break;
// ...
            case IRETURN:
                return eval.pop();
            case ISTORE:
                istore(instr[current++]);
                break;
            case ISUB:
                eval.isub();
                break;
            // Dummy implementation
            case ALOAD:
            case ALOAD_0:
            case ASTORE:
            case GETSTATIC:
            case INVOKEVIRTUAL:
            case LDC:
                System.out.println("Executing " + op + " with param bytes: ");
                for (int i = current; i < current + num; i++) {
                    System.out.print(instr[i] + " ");
                }
                current += num;
                System.out.println();
                break;
            case RETURN:
                return null;
            default:
                System.err.println("Saw " + op + " : can't happen. Exit.");
                System.exit(1);
        }
    }
}