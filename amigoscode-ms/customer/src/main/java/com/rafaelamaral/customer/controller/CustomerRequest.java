package com.rafaelamaral.customer.controller;

public record CustomerRequest(String firstName,
                              String lastName,

                              String email) {
}
