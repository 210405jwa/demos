class Car {

    constructor(horsepower, color, year, model) {
        this.horsepower = horsepower;
        this.color = color;
        this.year = year;
        this.model = model;
    }

    getHorsepower() {
        return this.horsepower;
    }

    getColor() {
        return this.color;
    }

    getYear() {
        return this.year;
    }

    getModel() {
        return this.model;
    }

}

export { Car };