describe('When we initialize a new Calculator', function() {
    let calculator;
    beforeEach(function() {
        calculator = new Calculator();
    });

    it('should be off', function() {
        expect(calculator.calculatorOn).toBeFalsy();
    })
    // You can nest describe functions inside other describe functions
    describe('when we turn on the calculator', function() {
        beforeEach(function() {
            calculator.turnOn();
        });

        it('should have calculatorOn be true', function () {
            expect(calculator.calculatorOn).toBeTruthy();
        });

        it('should add 1 and 1', function() {
            expect(calculator.add(1, 1)).toBe(2);
        })

        it('should add 10 and 20', function() {
            expect(calculator.add(10, 20)).toBe(30);
        })

        it('should subtract 10 and 20', function() {
            expect(calculator.subtract(10, 20)).toBe(-10);
        })
    });

    describe('when calculator is off', function() {
        it('should throw an error when we try to add', function() {
            expect(function() {
                calculator.add(1, 1)
            }).toThrowError("calculator is off");
        });

        it('should throw an error when we try to subtract', function() {
            expect(function() {
                calculator.subtract(2, 4)
            }).toThrowError("calculator is off");
        })
    })

});