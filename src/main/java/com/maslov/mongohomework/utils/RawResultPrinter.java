package com.maslov.mongohomework.utils;

import org.bson.Document;

public interface RawResultPrinter {
    @SuppressWarnings("unchecked")
    void prettyPrintRawResult(Document document);
}
