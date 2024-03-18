package com.homework;

/**
 * Interfața care specifică că o atracție turistică poate fi plătibilă.
 */
interface Payable {
    /**
     * Returnează prețul biletului pentru atracția turistică.
     *
     * @return Prețul biletului pentru atracția turistică.
     */
    double getTicketPrice();
}
