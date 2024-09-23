import readline from 'readline';

class Classroom {
    name: string;
    students: Set<string>;
    assignments: string[];

    constructor(name: string) {
        this.name = name;
        this.students = new Set<string>();
        this.assignments = [];
    }

    addStudent(studentId: string): void {
        if (this.students.has(studentId)) {
            throw new Error(`Student ${studentId} is already enrolled in ${this.name}`);
        }
        this.students.add(studentId);
    }

    scheduleAssignment(assignmentDetails: string): void {
        this.assignments.push(assignmentDetails);
    }
}

class VirtualClassroomManager {
    classrooms: Map<string, Classroom>;

    constructor() {
        this.classrooms = new Map<string, Classroom>();
    }

    addClassroom(className: string): void {
        if (this.classrooms.has(className)) {
            throw new Error(`Classroom ${className} already exists.`);
        }
        this.classrooms.set(className, new Classroom(className));
        console.log(`Classroom ${className} has been created.`);
    }

    addStudentToClassroom(studentId: string, className: string): void {
        const classroom = this.classrooms.get(className);
        if (!classroom) {
            throw new Error(`Classroom ${className} does not exist.`);
        }
        classroom.addStudent(studentId);
        console.log(`Student ${studentId} has been enrolled in ${className}.`);
    }

    scheduleAssignmentForClassroom(className: string, assignmentDetails: string): void {
        const classroom = this.classrooms.get(className);
        if (!classroom) {
            throw new Error(`Classroom ${className} does not exist.`);
        }
        classroom.scheduleAssignment(assignmentDetails);
        console.log(`Assignment for ${className} has been scheduled.`);
    }

    submitAssignment(studentId: string, className: string, assignmentDetails: string): void {
        const classroom = this.classrooms.get(className);
        if (!classroom) {
            throw new Error(`Classroom ${className} does not exist.`);
        }
        if (!classroom.students.has(studentId)) {
            throw new Error(`Student ${studentId} is not enrolled in ${className}.`);
        }
        console.log(`Assignment submitted by Student ${studentId} in ${className}.`);
    }

    listClassrooms(): void {
        if (this.classrooms.size === 0) {
            console.log('No classrooms available.');
        } else {
            console.log('Available Classrooms:');
            this.classrooms.forEach((classroom, className) => {
                console.log(`- ${className}`);
            });
        }
    }

    listStudentsInClassroom(className: string): void {
        const classroom = this.classrooms.get(className);
        if (!classroom) {
            throw new Error(`Classroom ${className} does not exist.`);
        }
        if (classroom.students.size === 0) {
            console.log(`No students enrolled in ${className}.`);
        } else {
            console.log(`Students in ${className}:`);
            classroom.students.forEach(studentId => {
                console.log(`- ${studentId}`);
            });
        }
    }
}

function handleError(error: unknown): void {
    if (error instanceof Error) {
        console.error(`Error: ${error.message}`);
    }
}


function main(): void {
    const manager = new VirtualClassroomManager();

    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    const askForCommand = () => {
        rl.question('Enter a command: ', (input) => {
            const args = input.trim().split(' ');
            const command = args.shift();

            try {
                switch (command) {
                    case 'add_classroom':
                        manager.addClassroom(args[0]);
                        break;
                    case 'add_student':
                        manager.addStudentToClassroom(args[0], args[1]);
                        break;
                    case 'schedule_assignment':
                        manager.scheduleAssignmentForClassroom(args[0], args.slice(1).join(' '));
                        break;
                    case 'submit_assignment':
                        manager.submitAssignment(args[0], args[1], args.slice(2).join(' '));
                        break;
                    case 'list_classrooms':
                        manager.listClassrooms();
                        break;
                    case 'list_students':
                        manager.listStudentsInClassroom(args[0]);
                        break;
                    case 'exit':
                        rl.close();
                        return;
                    default:
                        console.log('Invalid command.');
                }
            } catch (error) {
                handleError(error);
            }

            askForCommand();  
        });
    };

    console.log('Welcome to the Virtual Classroom Manager By Haard Shah.');
    askForCommand();
}

main();
